package com.example.qayourself.Generator

import com.example.qayourself.Room.Question

class QuestionGenerator {
    fun generateQuestion(id: Long
        , questionTitle: String
        , totalView: Int
        , totalCorrect: Int
        , totalIncorrect: Int
    ): Question {
        var percent = 0
        if (totalView==0){

        }else{
             percent = (totalCorrect * 100) / totalView

        }
        return Question(id, questionTitle, totalView, totalCorrect, totalIncorrect, percent)

    }
}