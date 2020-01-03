package com.example.qayourself.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuestionDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQuestion(question: Question)

    @Delete
    fun deleteQuestion(question: Question)

    @Query("SELECT *  FROM questions ORDER BY id DESC")
    fun getAllQuestion():LiveData<List<Question>>
}