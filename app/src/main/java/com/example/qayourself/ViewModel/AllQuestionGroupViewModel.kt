package com.example.qayourself.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qayourself.Room.Question
import com.example.qayourself.Room.RoomRepository

class AllQuestionGroupViewModel(private var repository: RoomRepository = RoomRepository()) : ViewModel() {

    private val allQuestion = repository.getAllOfQuestion()
    private var allQuestionLiveData=MutableLiveData<List<Question>>()

    init {
        allQuestionLiveData.postValue(allQuestion)
    }

    fun getAllQuestionLiveData():MutableLiveData<List<Question>>{
        return allQuestionLiveData
    }

}
