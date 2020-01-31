package com.example.qayourself.Room

import androidx.lifecycle.LiveData

interface QuestionRepository {
    suspend fun insertQuestion(question: Question): Long

    suspend fun deleteQuestion(question: Question)

    fun getAllQuestion(): LiveData<List<Question>>

    fun getQuestionById(id: Long): LiveData<Question>

    suspend fun updateQuestionTitleById(questionId: Long, questionTitle: String)

    suspend fun increaseQuestionViewById(questionId: Long)

    suspend fun updateQuestionWhenCorrectById(questionId: Long)

    suspend fun updateQuestionWhenIncorrectById(questionId: Long)

    suspend fun deleteQuestionById(questionId: Long)

}