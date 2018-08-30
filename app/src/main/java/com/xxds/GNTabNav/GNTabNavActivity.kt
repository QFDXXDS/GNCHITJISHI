package com.xxds.GNTabNav

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_gntab_nav.*
import com.xxds.CTJISHI.R
import com.xxds.CTJISHI.ScrollingActivity
import com.xxds.CTJISHI.SettingsActivity
import kotlinx.android.synthetic.main.activity_scrolling.*

class GNTabNavActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gntab_nav)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


    }

    fun onclick(v: View){


        val intent1 = Intent().setClass(this,ScrollingActivity::class.java)
        startActivityForResult(intent1,2)
        overridePendingTransition(R.anim.right_in,R.anim.left_out)

    }
}
