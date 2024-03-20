package com.geeks.pokeapiandroid15.presentation.utils

import androidx.fragment.app.Fragment
import com.geeks.pokeapiandroid15.R
import com.google.android.material.snackbar.Snackbar

fun Fragment.snackbar(text: String) {
    view?.let {
        Snackbar.make(it, text, Snackbar.LENGTH_INDEFINITE).apply {
            setAction(getString(R.string.ok)) {
                dismiss()
            }
        }
    }
}