package com.example.qayourself

import android.app.Application
import androidx.room.Room
import com.example.qayourself.Room.QuestionAndAnswerDatabase

class BaseApplication:Application() {

    companion object{
        lateinit var database: QuestionAndAnswerDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this
            ,QuestionAndAnswerDatabase::class.java
            ,"question_and_answer_database")
            .build()
    }
}