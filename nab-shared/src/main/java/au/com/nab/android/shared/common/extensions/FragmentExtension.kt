package au.com.nab.android.shared.common.extensions

import androidx.fragment.app.Fragment

/**
 * Extension method to provide hide keyboard for [Fragment].
 */
fun Fragment.hideKeyboardIfNeed() = activity?.hideKeyboardIfNeed()