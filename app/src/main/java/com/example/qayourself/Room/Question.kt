package com.example.qayourself.Room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.qayourself.adapter.PlayAllQuestionGroupAdapter

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
): PlayAllQuestionGroupAdapter.Searchable {
    override fun getSearchCriteria(): Question {
        return this    }
}