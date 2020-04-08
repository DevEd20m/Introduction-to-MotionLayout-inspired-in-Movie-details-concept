package com.example.customprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var motionBase: MotionLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPosition()
    }

    private fun getPosition() {
        motionBase?.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                Log.d("onTransitionTrigger", "Progress ${p1} | Progress ${p2}|Progress ${p3}")
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                Log.d("onTransitionStarted", "Progress ${p1} | Progress ${p2}")
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                (idTitle as? MotionLayout)?.let {
                    it.progress = p3
                }
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                Log.d("onTransitionCompleted", "Progress ${p1} ")
            }
        })
    }
}