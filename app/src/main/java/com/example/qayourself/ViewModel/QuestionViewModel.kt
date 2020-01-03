package com.example.qayourself.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qayourself.Room.Question
import com.example.qayourself.Room.RoomRepository

class QuestionViewModel(private var repository: RoomRepository = RoomRepository()) : ViewModel() {

    private val questionLiveData = MutableLiveData<Question>()
    private var title: String = ""
    private var viewCount: Int = 0
    lateinit var questionEntity: Question

    fun getQuestionLiveData(): MutableLiveData<Question> {
        return questionLiveData
    }

    private fun updateQuestion() {
        questionEntity = Question(0, title, viewCount)
        questionLiveData.postValue(questionEntity)

    }

    fun questionTitleFilled(title: String) {
        this.title = title
        updateQuestion()
    }

    fun viewCountFilled(count: Int) {
        this.viewCount = count
        updateQuestion()

    }

    fun saveQuestion() {
        repository.saveQuestion(questionEntity)
    }


}
