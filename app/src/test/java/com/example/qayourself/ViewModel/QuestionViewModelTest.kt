package com.example.qayourself.ViewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.qayourself.Generator.QuestionGenerator
import com.example.qayourself.Room.Question
import com.example.qayourself.Room.RoomRepository
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class QuestionViewModelTest {
    private lateinit var questionViewModel: QuestionViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var mockGenerator: QuestionGenerator

    @Mock
    lateinit var repository: RoomRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        questionViewModel = QuestionViewModel(repository, mockGenerator)
    }

    @Test
    fun testSetupQuestion() {
        val mockQuestion = Question(0, "title", 100, 50, 50, 50)
        `when`(mockGenerator.generateQuestion(0, "title", 100, 50, 50))
            .thenReturn(mockQuestion)

        questionViewModel.id = 0
        questionViewModel.title = "title"
        questionViewModel.totalView = 100
        questionViewModel.correctCount = 50
        questionViewModel.incorrectCount = 50

        questionViewModel.updateQuestion()
        Assert.assertEquals(mockQuestion, questionViewModel.question)
    }
}