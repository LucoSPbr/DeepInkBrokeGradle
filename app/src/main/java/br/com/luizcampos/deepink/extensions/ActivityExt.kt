package br.com.luizcampos.deepink.extensions

import android.app.Activity
import android.view.View

fun Activity.hideKeyboard(view: View) {
    hideKeyboard(currentFocus ?: View(this))
}

fun Activity.showKeyboard() {
    showKeyboard()
}