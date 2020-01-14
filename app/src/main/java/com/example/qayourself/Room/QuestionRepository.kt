package com.example.qayourself.Room

import androidx.lifecycle.LiveData

interface QuestionRepository {
    suspend fun insertQuestion(question: Question): Long

    suspend fun deleteQuestion(question: Question)

    fun getAllQuestion(): LiveData<List<Question>>

    fun getQestionById(id: Long): LiveData<Question>

    suspend fun updateQuestionById(questionId: Long, questionTitle: String)

}