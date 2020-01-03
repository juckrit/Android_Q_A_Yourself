package com.example.qayourself.Room

import androidx.annotation.NonNull
import androidx.room.*

@Entity(
    tableName = "choices",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = Question::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("questionId"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class Choice(
    @PrimaryKey(autoGenerate = true) @NonNull val id: Int,
    @ColumnInfo(name = "questionId", index = true)
    @NonNull val questionId: Int

)