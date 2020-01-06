package com.example.qayourself.Room

import androidx.lifecycle.LiveData

interface ChoiceRepository {
    suspend fun insertChoice(choice: Choice)

    suspend fun deleteChoice(choice: Choice)

    fun getAllChoice(questionId: Int): LiveData<List<Choice>>
}