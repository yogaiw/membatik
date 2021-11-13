package com.asylum.membatik.modules

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.asylum.membatik.R
import com.asylum.membatik.modules.account.AccountFragment
import com.asylum.membatik.modules.courses.CourseFragment
import com.asylum.membatik.modules.fav.FavoriteFragment
import com.asylum.membatik.modules.home.HomeFragment
import kotlinx.android.synthetic.main.activity_base.*

class BaseActivity : AppCompatActivity() {
    var fragments = mutableListOf<Fragment>()
    lateinit var activeFragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        navbarInit()
    }

    private fun navbarInit() {
        fragments.add(HomeFragment())
        fragments.add(CourseFragment())
        fragments.add(FavoriteFragment())
        fragments.add(AccountFragment())
        activeFragment = fragments[0]

        supportFragmentManager.beginTransaction()
            .add(R.id.content, fragments[0])
            .add(R.id.content, fragments[1]).hide(fragments[1])
            .add(R.id.content, fragments[2]).hide(fragments[2])
            .add(R.id.content, fragments[3]).hide(fragments[3])
            .commit()


        home_nav.selectedItemId = R.id.page_home

        home_nav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_home -> {
                    showFragment(fragments[0])
                    (fragments[0] as HomeFragment).getLatestProduct()
                    true
                }
                R.id.page_course -> {
                    showFragment(fragments[1])
                    true
                }
                R.id.page_fav -> {
                    showFragment(fragments[2])
                    true
                }
                R.id.page_akun -> {
                    showFragment(fragments[3])
                    true
                }
                else -> false
            }
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment).commit()
        activeFragment = fragment
    }


}