package com.example.qayourself.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ChoiceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChoice(choice: Choice)

    @Delete
    fun deleteChoice(choice: Choice)

    @Query("SELECT * FROM choices WHERE questionId = :question_Id")
    fun getChoice(question_Id:Int):LiveData<List<Choice>>



}
