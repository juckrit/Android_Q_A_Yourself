package com.example.qayourself.Room

import androidx.lifecycle.LiveData
import com.example.qayourself.BaseApplication

class RoomRepository :QuestionRepository{

    private val questionDao:QuestionDao = BaseApplication.database.questionDao()
    private val choiceDao:ChoiceDao = BaseApplication.database.choiceDao()

    override fun insertQuestion(question: Question) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteQuestion(question: Question) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllQuestion(): LiveData<List<Question>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}