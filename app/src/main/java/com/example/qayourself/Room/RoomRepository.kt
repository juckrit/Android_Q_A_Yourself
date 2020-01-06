package com.example.qayourself.Room

import androidx.lifecycle.LiveData
import com.example.qayourself.BaseApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RoomRepository : QuestionRepository, ChoiceRepository {


    private val parentJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob)

    private val questionDao: QuestionDao = BaseApplication.database.questionDao()
    private val choiceDao: ChoiceDao = BaseApplication.database.choiceDao()


    fun destroyJob() {
        parentJob.cancel()
    }

    fun saveQuestion(question: Question) {
        insertQuestion(question)
    }

    fun removeQuestion(question: Question) {
        deleteQuestion(question)
    }

    fun getAllOfQuestion(): LiveData<List<Question>> {
        return getAllQuestion()
    }


    override fun insertQuestion(question: Question) {
        coroutineScope.launch {
            questionDao.insertQuestion(question)
        }
    }

    override fun deleteQuestion(question: Question) {
        coroutineScope.launch {
            questionDao.deleteQuestion(question)
        }
    }

    override fun getAllQuestion(): LiveData<List<Question>> {
        return   questionDao.getAllQuestion()
    }

    override fun insertChoice(choice: Choice) {
        coroutineScope.launch {
            choiceDao.insertChoice(choice)

        }
    }

    override fun deleteChoice(choice: Choice) {
        coroutineScope.launch {
            choiceDao.deleteChoice(choice)

        }
    }

    override fun getAllChoice(questionId: Int): List<Choice> {
        var result: List<Choice> = listOf()

        coroutineScope.launch {
            result = choiceDao.getAllChoice(questionId)

        }
        return result
    }

}