package com.example.qayourself.Room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [(Question::class),(Choice::class)], version = 1)
abstract class QuestionAndAnswerDatabase :RoomDatabase() {
    abstract fun questionDao():QuestionDao
    abstract fun choiceDao():ChoiceDao
}