package com.example.qayourself.ViewModelFactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.qayourself.ViewModel.ChoiceViewModel

class ViewModelFactory(private val mContext: Context, private val question_id: Long) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass == ChoiceViewModel::class.java) {
            ChoiceViewModel(question_id) as T
        } else {

            super.create(modelClass)
        }
    }
}