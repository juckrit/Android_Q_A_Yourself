package com.example.qayourself.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.android.parcel.Parcelize

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: Question): Long

    @Delete
    suspend fun deleteQuestion(question: Question)

    @Query("SELECT *  FROM questions_table ORDER BY question_id DESC")
    fun getAllQuestion(): LiveData<List<Question>>

    @Query("SELECT *  FROM questions_table WHERE question_id == :questionId")
    fun getQuestionById(questionId: Long): LiveData<Question>

    @Query("UPDATE questions_table SET questionTitle=:questionTitle WHERE question_id = :questionId")
    suspend fun updateQuestionTitleById(questionId: Long, questionTitle: String)

    @Query("UPDATE questions_table SET totalView = totalView + 1 WHERE question_id =:questionId")
    suspend fun increaseQuestionViewById(questionId: Long)

    @Query("UPDATE questions_table SET totalCorrect = totalCorrect+1, correctPercent =((totalCorrect+1)*100)/totalView  WHERE question_id = :questionId")
    suspend fun updateQuestionWhenCorrectById(questionId: Long)

    @Query("UPDATE questions_table SET totalIncorrect = totalIncorrect+1  WHERE question_id = :questionId")
    suspend fun updateQuestionWhenIncorrectById(questionId: Long)

    @Query("DELETE FROM questions_table WHERE question_id=:questionId")
    suspend fun deleteQuestionById(questionId: Long)
}