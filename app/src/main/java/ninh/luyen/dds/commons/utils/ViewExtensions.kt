package ninh.luyen.dds.commons.utils

import android.text.Editable
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.set
import androidx.core.text.toSpannable

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.visibleInMillis(millis: Long) {
    this.visibility = View.VISIBLE
    this.postDelayed(
        { this?.visibility = View.GONE },
        millis
    )
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun EditText.isNullOrEmpty(): Boolean {
    return text.toString().isNullOrEmpty()
}

fun View?.onClick(function: () -> Unit) {
    this?.setOnClickListener {
        function.invoke()
    }
}

fun TextView.onClickSpannable(start: Int, end: Int, function: () -> Unit) {
    val spannable = this.text.toSpannable()
    spannable[start..end] = object : ClickableSpan() {
        override fun onClick(view: View) {
            function.invoke()
        }
    }
    this.movementMethod = LinkMovementMethod.getInstance()
    this.text = spannable
}

fun TextView.onClickSpannable(key: String, function: () -> Unit) {
    val start = this.text.indexOf(key)
    if (start >= 0) {
        onClickSpannable(start, start + key.length, function)
    }
}

fun EditText.afterTextChanged(function: () -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
        }

        override fun afterTextChanged(editable: Editable) {
            function.invoke()
        }
    })
}

fun EditText.onFocused(function: () -> Unit) {
    this.setOnFocusChangeListener { view, b ->
        if (b) {
            setSelection(text.length)
        }
        function.invoke()
    }
}

