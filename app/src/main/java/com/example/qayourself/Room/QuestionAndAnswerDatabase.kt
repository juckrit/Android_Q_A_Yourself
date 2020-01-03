package com.example.qayourself.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [(Question::class), (Choice::class)], version = 1)
abstract class QuestionAndAnswerDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao
    abstract fun choiceDao(): ChoiceDao

    companion object {
        @Volatile
        private var instance: QuestionAndAnswerDatabase? = null

        fun getInstance(context: Context): QuestionAndAnswerDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): QuestionAndAnswerDatabase {
            return Room.databaseBuilder(
                context
                , QuestionAndAnswerDatabase::class.java
                , "question_and_answer_database"
            ).build()
        }
    }
}