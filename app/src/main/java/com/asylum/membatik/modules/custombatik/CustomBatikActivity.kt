package com.asylum.membatik.modules.custombatik

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Matrix
import android.graphics.PointF
import android.os.Bundle
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnLayout
import com.almeros.android.multitouch.MoveGestureDetector
import com.asylum.membatik.R
import com.asylum.membatik.modules.charts.ChartsActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_custom_batik.*

class CustomBatikActivity : AppCompatActivity() {
    private lateinit var imageMatrix: Matrix
    private var translate = PointF(0f, 0f)
    private var scale = 1f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_batik)

        val bottomSheetCustom = BottomSheetDialog(this)
        bottomSheetCustom.setContentView(R.layout.bottom_sheet_custom)

        btn_next_custom.setOnClickListener {
            bottomSheetCustom.show()
        }

        bottomSheetCustom.findViewById<Button>(R.id.btn_keranjang_custom)?.setOnClickListener {
            startActivity(Intent(this, ChartsActivity::class.java))
        }

        rg_tampilan.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                rgDepan.id -> {
                    hideEditor()
                    viewWrapper.visibility = View.VISIBLE
                }
                rgBelakang.id -> {
                    hideEditor()
                    tampakBelakang.visibility = View.VISIBLE
                }
                rgKiri.id -> {
                    hideEditor()
                    tampakKiri.visibility = View.VISIBLE
                }
                rgKanan.id -> {
                    hideEditor()
                    tampakKanan.visibility = View.VISIBLE
                }
            }
        }

        batik.doOnLayout {
            var moveGestureDetector = MoveGestureDetector(this, MoveGestureHandler())
            val scaleGestureDetector = ScaleGestureDetector(this, ScaleGestureHandler())
            val center = PointF(
                batik.measuredWidth.toFloat() / 2f,
                batik.measuredHeight.toFloat() / 2f
            )

            // Centers the image
            imageMatrix = Matrix().apply {
                setTranslate(
                    center.x - batik.drawable.intrinsicWidth / 2f,
                    center.y - batik.drawable.intrinsicHeight / 2f
                )
            }
            batik.imageMatrix = imageMatrix

            batik.setOnTouchListener { _, event ->
                moveGestureDetector.onTouchEvent(event)
                scaleGestureDetector.onTouchEvent(event)

                batik.imageMatrix = Matrix().apply {
                    set(imageMatrix)
                    postTranslate(-center.x, -center.y)
                    postScale(scale, scale)
                    postTranslate(center.x + translate.x, center.y + translate.y)
                }

                true
            }
        }
    }

    inner class MoveGestureHandler : MoveGestureDetector.SimpleOnMoveGestureListener() {
        override fun onMove(detector: MoveGestureDetector): Boolean {
            translate = detector.focusDelta
            return super.onMove(detector)
        }

        override fun onMoveEnd(detector: MoveGestureDetector) {
            imageMatrix = Matrix(batik.imageMatrix)
            translate = PointF(0f, 0f)
            super.onMoveEnd(detector)
        }
    }


    inner class ScaleGestureHandler : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scale = detector.scaleFactor

            return super.onScale(detector)
        }

        override fun onScaleEnd(detector: ScaleGestureDetector?) {
            imageMatrix = Matrix(batik.imageMatrix)
            scale = 1f
            super.onScaleEnd(detector)
        }
    }

    fun hideEditor() {
        viewWrapper.visibility = View.GONE
        tampakBelakang.visibility = View.GONE
        tampakKanan.visibility = View.GONE
        tampakKiri.visibility = View.GONE
    }


}