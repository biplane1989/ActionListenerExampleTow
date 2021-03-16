package com.example.actionlistenerexample.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope

abstract class BaseDialog : DialogFragment() {
    protected fun sendAction(actionName: String, data: Any? = null) {
        lifecycleScope.launchWhenResumed {
            getBaseActivity()?.let {
                it.sendAction(actionName, data)
            }
        }
    }

    protected fun getBaseActivity(): BaseActivity? {
        if (activity != null) {
            return activity as BaseActivity
        }
        return null
    }
}