package com.simba.musicwiki.utils

import android.app.Activity
import android.view.View
import android.view.textclassifier.ConversationActions.Message
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

fun Activity.isNetworkConnected(): Boolean {
    val isConnected = NetworkUtils.isNetworkConnected(applicationContext)
    return if (isConnected) true else {
        Toast.makeText(
            this,
            "No internet connection",
            Toast.LENGTH_SHORT
        ).show()
        false
    }
}

fun Activity.showToastMessage(message: String) {
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_SHORT
    ).show()
}

fun ProgressBar.showProgressBar(isToShow: Boolean) {
    visibility = if (isToShow) View.VISIBLE else View.GONE
}

fun ChipGroup.checkedChipContents(): String {
    var checkedContent: String = ""
    for (i in 0 until childCount) {
        val child: View = getChildAt(i)
        if (child is Chip) {
            if ((child as Chip).isChecked) {
                checkedContent = child.text as String
            }
        }
    }
    return checkedContent
}