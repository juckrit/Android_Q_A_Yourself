package com.example.qayourself.Room

import androidx.lifecycle.LiveData

interface ChoiceRepository {
    suspend fun insertChoice(choices :MutableList<Choice>)

    suspend fun deleteChoice(choice: Choice)

    fun getAllChoice(questionId: Long): LiveData<List<Choice>>
}