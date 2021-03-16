package com.example.actionlistenerexample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope

abstract class BaseFragment : Fragment(), Observer<ActionMeta> {

    internal open fun onActionReceived(actionName: String, data: Any?): Boolean {
        return false
    }

    protected fun sendAction(actionName: String, data: Any? = null) {
        lifecycleScope.launchWhenResumed {
            getBaseActivity()?.let {
                it.sendAction(actionName, data)
            }
        }
    }

    override fun onChanged(actionMeta: ActionMeta?) {
        actionMeta?.let {
            onActionReceived(it.actionName, it.data)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getBaseActivity()?.observerActionMeta(viewLifecycleOwner, this)
    }

    protected fun getBaseActivity(): BaseActivity? {
        if (activity != null) {
            return activity as BaseActivity
        }
        return null
    }
}