package com.example.fragmenttest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
    private val TAG = "MyViewModel"
    var teamAScore:Int = 0
    var teamBScore:Int = 0

}