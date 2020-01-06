package com.example.qayourself.Room

import androidx.lifecycle.LiveData

interface QuestionRepository {
    suspend fun insertQuestion(question: Question)

    suspend fun deleteQuestion(question: Question)

    fun getAllQuestion(): LiveData<List<Question>>

}