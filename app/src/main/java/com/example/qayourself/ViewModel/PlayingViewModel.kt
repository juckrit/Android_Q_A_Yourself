package com.example.qayourself.ViewModel

import androidx.lifecycle.ViewModel
import com.example.qayourself.Room.RoomRepository

class PlayingViewModel(
    val questionId: Long,
    private val repository: RoomRepository = RoomRepository()
) : ViewModel() {

    private var questionLiveData = repository.getQuestionByQuestoinId(questionId)
    private var choiceLiveData = repository.getChoiceByQuestionId(questionId)

    fun getQuestionLiveData() = questionLiveData
    fun getChoiceLiveData() = choiceLiveData
}
