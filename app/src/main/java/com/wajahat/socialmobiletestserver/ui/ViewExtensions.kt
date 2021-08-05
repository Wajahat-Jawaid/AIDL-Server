package com.wajahat.socialmobiletestserver.ui

import android.os.SystemClock
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar

/**
 * Created by Wajahat Jawaid(wajahatjawaid@gmail.com)
 */
fun ProgressBar.hide() {
    visibility = View.GONE
}

fun View.throttlingClickListener(debounceTime: Long = 400L, action: () -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else action()

            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

fun EditText.toTrimmedString(): String {
    return this.text.toString().trim()
}