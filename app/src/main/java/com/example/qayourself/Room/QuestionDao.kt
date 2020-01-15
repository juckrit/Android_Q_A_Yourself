package com.example.qayourself.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.android.parcel.Parcelize

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: Question):Long

    @Delete
    suspend fun deleteQuestion(question: Question)

    @Query("SELECT *  FROM questions_table ORDER BY question_id DESC")
    fun getAllQuestion(): LiveData<List<Question>>

    @Query("SELECT *  FROM questions_table WHERE question_id == :questionId")
    fun getQuestionById(questionId:Long):LiveData<Question>

    @Query("UPDATE questions_table SET questionTitle=:questionTitle WHERE question_id = :questionId")
    suspend fun updateQuestionById(questionId:Long,questionTitle:String)

    @Query("UPDATE questions_table SET totalView = totalView + 1 WHERE question_id =:questionId")
    suspend fun increaseQuestionViewById(questionId:Long)
}