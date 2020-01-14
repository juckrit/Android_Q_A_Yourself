package com.example.qayourself.Room

import androidx.annotation.NonNull
import androidx.room.*

@Entity(
    tableName = "choices_table",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = Question::class,
            parentColumns = arrayOf("question_id"),
            childColumns = arrayOf("question_id"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class Choice(
    @ColumnInfo(name = "choice_id", index = true)
    @PrimaryKey(autoGenerate = true) @NonNull val id: Long,
    @ColumnInfo(name = "question_id", index = true)
    @NonNull val questionId: Long,
    var isTrue: Boolean,
    var choiceTitle: String
)