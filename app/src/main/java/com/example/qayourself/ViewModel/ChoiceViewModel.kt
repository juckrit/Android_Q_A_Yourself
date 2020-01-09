package com.example.qayourself.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.qayourself.Room.ChoiceRepository
import com.example.qayourself.Room.Question
import com.example.qayourself.Room.RoomRepository

class ChoiceViewModel(val question_id:Long) : ViewModel() {
    private var repository: RoomRepository = RoomRepository()

    var choice1 = ""
    var choice2 = ""
    var choice3 = ""
    var choice4 = ""
    var question_title = ""
    private  var questionLiveData: LiveData<Question> = repository.getQuestionByQuestoinId(question_id)

    fun getQuestionLiveData():LiveData<Question>{
        return questionLiveData
    }




}



