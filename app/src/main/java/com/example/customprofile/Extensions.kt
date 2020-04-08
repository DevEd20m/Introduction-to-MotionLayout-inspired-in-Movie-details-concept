package com.example.customprofile

import androidx.constraintlayout.motion.widget.MotionLayout

fun MotionLayout.getPosition(getPosition: (Float) -> Unit) {
    this.setTransitionListener(object : MotionLayout.TransitionListener {
        override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}

        override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}

        override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            getPosition.invoke(p3)
        }

        override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {}

    })
}


