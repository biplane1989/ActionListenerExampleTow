package com.example.actionlistenerexampletow.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.viewModels
import com.example.actionlistenerexample.base.BaseActivity
import com.example.actionlistenerexampletow.R

class MainActivity : BaseActivity() {

    val model: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model.mainLiveData.value = "holiday"
    }



//    override fun onActionReceived(actionName: String, data: Any?): Boolean {
//        if (TextUtils.equals(actionName,Constance.SEND_ACTION_HOME_TO_DETAIL)){
//            Log.d("apple", "activity: detail: "+ data)
//        }
//        return super.onActionReceived(actionName, data)
//    }
}