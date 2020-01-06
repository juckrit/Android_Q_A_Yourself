package com.example.qayourself.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qayourself.Generator.QuestionGenerator
import com.example.qayourself.Room.Question
import com.example.qayourself.Room.RoomRepository
import kotlinx.coroutines.launch

class QuestionViewModel(
    private var repository: RoomRepository = RoomRepository()
    , private val generator: QuestionGenerator = QuestionGenerator()
) : ViewModel() {

    private val questionLiveData = MutableLiveData<Question>()
    private var title: String = ""
    private var viewCount: Int = 0
    private var correctCount: Int = 0
    private var incorrectCount: Int = 0
    private var percentCorrectCount: Int = 0
    lateinit var questionEntity: Question

//    fun stopCoroutineJob(){
//        repository.destroyJob()
//    }

    fun getQuestionLiveData(): MutableLiveData<Question> {
        return questionLiveData
    }

    private fun updateQuestion() {
        questionEntity =
            generator.generateQuestion(0, title, viewCount, correctCount, incorrectCount)
        questionLiveData.postValue(questionEntity)

    }

    fun questionTitleFilled(title: String) {
        this.title = title
        updateQuestion()
    }

    fun viewCountFilled(count: Int) {
        this.viewCount = count

        updateQuestion()

    }

    fun correctCountFilled(count: Int) {
        this.correctCount = count
        updateQuestion()

    }

    fun incorrectCountFilled(count: Int) {
        this.incorrectCount = count
        updateQuestion()

    }


    fun saveQuestion() {

        viewModelScope.launch {
            repository.saveQuestion(questionEntity)

        }
    }


}
