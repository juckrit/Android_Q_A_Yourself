package com.example.qayourself.Room

import androidx.lifecycle.LiveData

interface ChoiceRepository {
    suspend fun insertChoice(choices :MutableList<Choice>)

    suspend fun deleteChoice(choice: Choice)

    fun getChoiceByQuestionId(questionId: Long): LiveData<List<Choice>>

    suspend fun updateChoiceById(choiceId:Long,choiceTitle:String,isTrue:Boolean)

}