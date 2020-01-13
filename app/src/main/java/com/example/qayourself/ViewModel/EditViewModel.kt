package com.example.qayourself.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qayourself.Room.Choice
import com.example.qayourself.Room.Question
import com.example.qayourself.Room.RoomRepository

class EditViewModel(
    val questionId: Long,
    private val repository: RoomRepository = RoomRepository()
) : ViewModel() {
    // TODO: Implement the ViewModel

    var question_title: String? = ""
    var choice1: String? = ""
    var choice2: String? = ""
    var choice3: String? = ""
    var choice4: String? = ""
    var is_choice1_correct = true
    var is_choice2_correct = false
    var is_choice3_correct = false
    var is_choice4_correct = false

    private var questionLiveData = MutableLiveData<Question>()
    private var choicesLiveData = MutableLiveData<List<Choice>>()

    init {
        fetchFromDatabase()
    }

    fun getQuestionLiveData(): MutableLiveData<Question> {
        return questionLiveData
    }

    fun getChoicesLiveData(): MutableLiveData<List<Choice>> {
        return choicesLiveData

    }


    fun fetchFromDatabase() {
        val question = repository.getQuestionByQuestoinId(questionId)
        val choices = repository.getAllChoice(questionId)
        question_title = question.value?.questionTitle
        choice1 = choices.value?.get(0)?.choiceTitle
        choice2 = choices.value?.get(1)?.choiceTitle
        choice3 = choices.value?.get(2)?.choiceTitle
        choice4 = choices.value?.get(3)?.choiceTitle
        is_choice1_correct = choices.value?.get(0)?.isTrue!!
        is_choice2_correct = choices.value?.get(1)?.isTrue!!
        is_choice3_correct = choices.value?.get(2)?.isTrue!!
        is_choice4_correct = choices.value?.get(3)?.isTrue!!

        questionLiveData.postValue(question.value)
        choicesLiveData.postValue(choices.value)
    }
}
