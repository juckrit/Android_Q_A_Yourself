package com.example.qayourself.Room

import com.example.qayourself.Generator.QuestionGenerator
import junit.framework.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class QuestionGeneraterTest {
    private lateinit var questionGenerator: QuestionGenerator

    @Before
    fun setUp() {
        questionGenerator = QuestionGenerator()
    }

    @Test
    fun testGenerateCorrectPercent() {
        val id = 0
        val title = "title"
        val view = 100
        val correct = 50
        val incorrect = 50
        val percent = 50
        val expectedQuestion = Question(id, title, view, correct, incorrect, percent)
        Assert.assertEquals(expectedQuestion, questionGenerator.generateQuestion(id,title,view,correct,incorrect))

    }
}

