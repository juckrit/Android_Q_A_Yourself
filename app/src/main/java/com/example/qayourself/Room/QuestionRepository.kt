package com.example.qayourself.Room

import androidx.lifecycle.LiveData

interface QuestionRepository {
    fun insertQuestion(question: Question)

    fun deleteQuestion(question: Question)

    fun getAllQuestion(): List<Question>

}