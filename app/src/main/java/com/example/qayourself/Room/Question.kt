package com.example.qayourself.Room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "questions_table"
)
data class Question(
    @ColumnInfo(name = "question_id", index = true)
    @PrimaryKey(autoGenerate = true) @NonNull val id: Long,
    var questionTitle: String,
    var totalView: Int,
    var totalCorrect: Int,
    var totalIncorrect: Int,
    var correctPercent: Int
)