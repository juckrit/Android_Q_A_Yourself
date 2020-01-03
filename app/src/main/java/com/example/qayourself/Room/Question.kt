package com.example.qayourself.Room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "questions"
)
data class Question(
    @ColumnInfo(name = "question_id", index = true)
    @PrimaryKey(autoGenerate = true) @NonNull val id: Int,
    val question: String,
    val totalView: Int
)