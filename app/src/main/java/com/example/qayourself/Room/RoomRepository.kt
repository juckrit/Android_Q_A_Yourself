package com.example.qayourself.Room

import androidx.lifecycle.LiveData
import com.example.qayourself.BaseApplication

class RoomRepository : QuestionRepository, ChoiceRepository {


//    private val parentJob = Job()
//    private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob)

    private val questionDao: QuestionDao = BaseApplication.database.questionDao()
    private val choiceDao: ChoiceDao = BaseApplication.database.choiceDao()


//    fun destroyJob() {
//        parentJob.cancel()
//    }



//    suspend fun addChoices(choices: MutableList<Choice>) {
//        insertChoice(choices)
//    }

//    suspend fun updateQuestionByID(questionId: Long, questionTitle: String) {
//        updateQuestionByID(questionId, questionTitle)
//    }

//    fun getQuestionByQuestoinId(id: Long): LiveData<Question> {
//        return getQuestionById(id)
//    }
//
//    suspend fun saveQuestion(question: Question): Long {
//        return insertQuestion(question)
//    }
//
//    suspend fun removeQuestion(question: Question) {
//        deleteQuestion(question)
//    }
//
//    fun getAllOfQuestion(): LiveData<List<Question>> {
//        return getAllQuestion()
//    }

    override suspend fun increaseQuestionViewById(questionId: Long) {
        questionDao.increaseQuestionViewById(questionId)
    }

    override fun getQuestionById(id: Long): LiveData<Question> {
        return questionDao.getQuestionById(id)
    }


    override suspend fun insertQuestion(question: Question): Long {
        val id = questionDao.insertQuestion(question)
        return id
    }

    override suspend fun deleteQuestion(question: Question) {
        questionDao.deleteQuestion(question)
    }

    override fun getAllQuestion(): LiveData<List<Question>> {
        return questionDao.getAllQuestion()
    }


    override suspend fun insertChoice(choices: MutableList<Choice>) {
        choiceDao.insertChoice(choices)
    }

    override suspend fun deleteChoice(choice: Choice) {
        choiceDao.deleteChoice(choice)

    }

    override fun getChoiceByQuestionId(questionId: Long): LiveData<List<Choice>> {
        return choiceDao.getChoiceByQuestionId(questionId)
    }


    suspend override fun updateQuestionById(questionId: Long, questionTitle: String) {
        questionDao.updateQuestionById(questionId, questionTitle)
    }

    override suspend fun updateChoiceById(choiceId: Long, choiceTitle: String, isTrue: Boolean) {
        choiceDao.updateChoiceById(choiceId, choiceTitle, isTrue)
    }

}