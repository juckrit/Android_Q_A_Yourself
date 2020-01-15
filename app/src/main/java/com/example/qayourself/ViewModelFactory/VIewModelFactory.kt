package com.example.qayourself.ViewModelFactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.qayourself.Room.RoomRepository
import com.example.qayourself.ViewModel.ChoiceViewModel
import com.example.qayourself.ViewModel.EditViewModel
import com.example.qayourself.ViewModel.PlayingViewModel

class ViewModelFactory(private val mContext: Context, private val question_id: Long) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass == ChoiceViewModel::class.java) {
            ChoiceViewModel(question_id) as T
        }else if (modelClass == EditViewModel::class.java){
            EditViewModel(question_id, RoomRepository()) as T
        }else if (modelClass == PlayingViewModel::class.java){
            PlayingViewModel(question_id, RoomRepository()) as T
        }

        else {

            super.create(modelClass)
        }
    }
}