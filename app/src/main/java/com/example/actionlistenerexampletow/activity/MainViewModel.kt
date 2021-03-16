package com.example.actionlistenerexampletow.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var action = ""
    val mainLiveData = MutableLiveData<String>()

    fun sendHomeToDetail(action: String, data: String) {

    }
}