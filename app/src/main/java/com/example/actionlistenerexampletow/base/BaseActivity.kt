package com.example.actionlistenerexample.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.fragment.NavHostFragment

data class ActionMeta(val actionName: String, val data: Any?)
abstract class BaseActivity : AppCompatActivity() {
    private val actionMeta = MutableLiveData<ActionMeta>()
    fun observerActionMeta(lifecycle: LifecycleOwner, observer: Observer<ActionMeta>) {
        actionMeta.observe(lifecycle, observer)
    }

    fun sendAction(actionName: String, data: Any?) {
        actionMeta.value = ActionMeta(actionName, data)
        /*lifecycleScope.launchWhenResumed {
            if (!onActionReceived(actionName, data)) {
                supportFragmentManager.fragments.forEach {
                    sendActionToFragment(it, actionName, data)
                }
            }
        }*/
    }

    /* protected open fun onActionReceived(actionName: String, data: Any?): Boolean {
         return false
     }

     private fun sendActionToFragment(fragment: Fragment, actionName: String, data: Any?) {
         if (fragment is BaseFragment) {
             if (fragment.onActionReceived(actionName, data)) {
                 return
             }
         }
             fragment.childFragmentManager.fragments.forEach {
                 sendActionToFragment(it, actionName, data)
             }


     }*/
}