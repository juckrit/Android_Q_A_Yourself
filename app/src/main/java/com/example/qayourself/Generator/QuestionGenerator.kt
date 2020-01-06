package com.example.qayourself.Generator

import com.example.qayourself.Room.Question

class QuestionGenerator {
    fun generateQuestion(id: Int
        , questionTitle: String
        , totalView: Int
        , totalCorrect: Int
        , totalIncorrect: Int
    ): Question {
        val percent = (totalCorrect * 100) / totalView
        return Question(id, questionTitle, totalView, totalCorrect, totalIncorrect, percent)

    }
}