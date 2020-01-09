package com.example.qayourself.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qayourself.Generator.QuestionGenerator
import com.example.qayourself.Room.Question
import com.example.qayourself.Room.RoomRepository
import com.example.qayourself.Util.showToast
import kotlinx.coroutines.launch

class QuestionViewModel(private var repository: RoomRepository = RoomRepository()
    , private val generator: QuestionGenerator = QuestionGenerator()
    , val id :Long =0
) : ViewModel() {

    private val mQuestionLiveData = MutableLiveData<Question>()
    var title: String = ""
    var totalView: Int = 0
    var correctCount: Int = 0
    var incorrectCount: Int = 0
    //    var percentCorrectCount: Int = 0
    lateinit var question: Question

    private val saveLiveData = MutableLiveData<Long>()


    fun getSaveLiveData(): LiveData<Long> = saveLiveData

//    fun stopCoroutineJob(){
//        repository.destroyJob()
//    }

    fun getQuestionLiveData(): MutableLiveData<Question> {
        return mQuestionLiveData
    }

    fun updateQuestion() {
        question =
            generator.generateQuestion(id, title, totalView, correctCount, incorrectCount)
        mQuestionLiveData.postValue(question)

    }

    fun questionTitleFilled(title: String) {
        this.title = title
        updateQuestion()
    }

    fun viewCountFilled(count: Int) {
        this.totalView = count

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
        if (canSaveQuestion()) {
            var id = 0L
            viewModelScope.launch {
                id = repository.saveQuestion(question)
                saveLiveData.postValue(id)

            }
        } else {
            saveLiveData.postValue(0L)

        }

    }

    fun canSaveQuestion(): Boolean {
        if (title.isNullOrEmpty()) {
            return false
        } else {
            return true
        }
    }


}
