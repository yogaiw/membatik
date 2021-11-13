
import android.view.MotionEvent

import android.graphics.PointF

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Matrix

import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.annotation.Nullable

import androidx.annotation.RequiresApi



class CustomImageView : androidx.appcompat.widget.AppCompatImageView, View.OnTouchListener {
    // these matrices will be used to move and zoom image
    private val customMatrix: Matrix = Matrix()
    private val savedMatrix: Matrix = Matrix()
    private var mode = NONE

    // remember some things for zooming
    private val start = PointF()
    private val mid = PointF()
    private var oldDist = 1f
    private var d = 0f
    private var newRot = 0f
    private var lastEvent: FloatArray? = null

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, @Nullable attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(
        context: Context,
        @Nullable attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(context)
    }


    @SuppressLint("ClickableViewAccessibility")
    private fun init(context: Context) {
        this.setOnTouchListener(this@CustomImageView)
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        val view: ImageView = v as ImageView
        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_DOWN -> {
                savedMatrix.set(customMatrix)
                start[event.x] = event.y
                mode = DRAG
                lastEvent = null
            }
            MotionEvent.ACTION_POINTER_DOWN -> {
                oldDist = spacing(event)
                if (oldDist > 10f) {
                    savedMatrix.set(customMatrix)
                    midPoint(mid, event)
                    mode = ZOOM
                }
                lastEvent = FloatArray(4)
                lastEvent!![0] = event.getX(0)
                lastEvent!![1] = event.getX(1)
                lastEvent!![2] = event.getY(0)
                lastEvent!![3] = event.getY(1)
                d = rotation(event)
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                mode = NONE
                lastEvent = null
            }
            MotionEvent.ACTION_MOVE -> if (mode == DRAG) {
                customMatrix.set(savedMatrix)
                val dx = event.x - start.x
                val dy = event.y - start.y
                customMatrix.postTranslate(dx, dy)
            } else if (mode == ZOOM) {
                val newDist = spacing(event)
                if (newDist > 10f) {
                    customMatrix.set(savedMatrix)
                    val scale = newDist / oldDist
                    customMatrix.postScale(scale, scale, mid.x, mid.y)
                }
                if (lastEvent != null && event.pointerCount == 3) {
                    newRot = rotation(event)
                    val r = newRot - d
                    val values = FloatArray(9)
                    customMatrix.getValues(values)
                    val tx = values[2]
                    val ty = values[5]
                    val sx = values[0]
                    val xc: Float = view.getWidth() / 2 * sx
                    val yc: Float = view.getHeight() / 2 * sx
                    customMatrix.postRotate(r, tx + xc, ty + yc)
                }
            }
        }
        view.setImageMatrix(customMatrix)
        return true
    }

    /**
     * Determine the space between the first two fingers
     */
    private fun spacing(event: MotionEvent): Float {
        val x = event.getX(0) - event.getX(1)
        val y = event.getY(0) - event.getY(1)
        return Math.sqrt((x * x + y * y).toDouble()).toFloat()
    }

    /**
     * Calculate the mid point of the first two fingers
     */
    private fun midPoint(point: PointF, event: MotionEvent) {
        val x = event.getX(0) + event.getX(1)
        val y = event.getY(0) + event.getY(1)
        point[x / 2] = y / 2
    }

    /**
     * Calculate the degree to be rotated by.
     *
     * @param event
     * @return Degrees
     */
    private fun rotation(event: MotionEvent): Float {
        val delta_x = (event.getX(0) - event.getX(1)).toDouble()
        val delta_y = (event.getY(0) - event.getY(1)).toDouble()
        val radians = Math.atan2(delta_y, delta_x)
        return Math.toDegrees(radians).toFloat()
    }

    companion object {
        // we can be in one of these 3 states
        private const val NONE = 0
        private const val DRAG = 1
        private const val ZOOM = 2
    }
}