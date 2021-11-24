package com.example.kotlin14hw

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.ArrayList

class MainViewModel : ViewModel() {
    private var mCounter = 0
    var commands = MutableLiveData<ArrayList<String>>()
    var counter = MutableLiveData<Int>()

    var plus = "+"
    var minus = "-"

    fun onIncrementClick() {
        counter.value = ++mCounter

        /* counter.value = ++mCounter*/
    }

    fun onDecrementClick() {
        counter.value = --mCounter
    }

    fun setCommands(s: ArrayList<String>) {
        commands.value = s
    }
}