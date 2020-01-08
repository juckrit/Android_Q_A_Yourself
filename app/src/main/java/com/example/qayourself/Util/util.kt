package com.example.qayourself.Util

import android.content.Context
import android.widget.Toast

fun showToast(context: Context?,text:String){
    context?.let {
        Toast.makeText(it,text,Toast.LENGTH_SHORT).show()
    }
}