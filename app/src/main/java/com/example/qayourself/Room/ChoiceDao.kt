package com.example.qayourself.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ChoiceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChoice(choice: Choice)

    @Delete
    suspend fun deleteChoice(choice: Choice)

    @Query("SELECT * FROM choices WHERE question_id = :questionId")
    fun getAllChoice(questionId:Int):LiveData<List<Choice>>



}
