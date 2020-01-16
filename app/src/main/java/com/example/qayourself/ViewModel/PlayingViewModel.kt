package com.example.qayourself.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qayourself.Room.Question
import com.example.qayourself.Room.RoomRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PlayingViewModel(
    val questionId: Long,
    private val repository: RoomRepository = RoomRepository()
) : ViewModel() {

    private var questionLiveData = repository.getQuestionById(questionId)
    private var choiceLiveData = repository.getChoiceByQuestionId(questionId)

    fun getQuestionLiveData(): LiveData<Question> {
        viewModelScope.launch {
            increaseQuestionViewById()

        }
        return questionLiveData
    }

    fun getChoiceLiveData() = choiceLiveData

    suspend fun increaseQuestionViewById(){
        repository.increaseQuestionViewById(questionId)
    }


    suspend fun updateQuestionStat(view:Int,correct:Int,incorrect:Int,percent:Int) {
        questionLiveData.value?.totalView = view
        questionLiveData.value?.totalCorrect=correct
        questionLiveData.value?.totalIncorrect=incorrect
        questionLiveData.value?.correctPercent=percent

    }

    fun updateQuestionWhenCorrectById() {
        runBlocking {
            repository.updateQuestionWhenCorrectById(questionId)
        }
    }

    fun updateQuestionWhenIncorrectById() {
        runBlocking {
            repository.updateQuestionWhenIncorrectById(questionId)
        }
    }
}
