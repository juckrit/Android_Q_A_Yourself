package com.example.qayourself.Room

import androidx.lifecycle.LiveData

interface ChoiceRepository {
    fun insertChoice(choice: Choice)

    fun deleteChoice(choice: Choice)

    fun getAllChoice(questionId:Int): List<Choice>
}