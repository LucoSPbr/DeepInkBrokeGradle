package br.com.luizcampos.deepink.extensions

import android.content.Context
import android.view.View

fun Context.hideKeyboard(view: View) {
    view.hideKeyboard()
}


fun Context.showKeyboard(view: View) {
    view.showKeyboard()
}