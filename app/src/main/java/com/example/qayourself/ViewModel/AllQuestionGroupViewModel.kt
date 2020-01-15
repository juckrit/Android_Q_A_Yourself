package com.example.qayourself.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qayourself.Room.Question
import com.example.qayourself.Room.RoomRepository

class AllQuestionGroupViewModel(private var repository: RoomRepository = RoomRepository()) : ViewModel() {

    private val allQuestionLiveData = repository.getAllQuestion()
//    private var allQuestionLiveData= MutableLiveData<List<Question>>()

//    init {
//        allQuestionLiveData.postValue(allQuestion.value)
//    }

    fun getAllQuestionLiveData():LiveData<List<Question>>{
        return allQuestionLiveData
    }

}
