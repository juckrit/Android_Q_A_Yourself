package com.example.qayourself.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ChoiceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChoice(choices :MutableList<Choice>)

    @Delete
    suspend fun deleteChoice(choice: Choice)

    @Query("SELECT * FROM choices_table WHERE question_id = :questionId")
    fun getAllChoice(questionId:Long):LiveData<List<Choice>>

    @Query("UPDATE choices_table SET choiceTitle=:choiceTitle, isTrue = :isTrue WHERE choice_id = :choiceId")
    suspend fun updateChoiceById(choiceId:Long,choiceTitle:String,isTrue:Boolean)



}
