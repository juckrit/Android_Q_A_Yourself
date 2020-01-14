package com.example.qayourself.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qayourself.Room.Choice
import com.example.qayourself.Room.Question
import com.example.qayourself.Room.RoomRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

   private var questionLiveData = repository.getQuestionByQuestoinId(questionId)
   private var choicesLiveData = repository.getAllChoice(questionId)

    fun getQuestionLiveData(): LiveData<Question> {
        return questionLiveData
    }

    fun getChoicesLiveData(): LiveData<List<Choice>> {
        return choicesLiveData

    }

    fun saveToDB(){
//        viewModelScope.launch {
//            repository.updateQuestionById(questionLiveData.value?.id!!,questionLiveData.value?.questionTitle!!)
//            repository.updateChoiceById(choicesLiveData.value!![0].id,choicesLiveData.value!![0].choiceTitle,choicesLiveData.value!![0].isTrue)
//            repository.updateChoiceById(choicesLiveData.value!![1].id,choicesLiveData.value!![1].choiceTitle,choicesLiveData.value!![1].isTrue)
//            repository.updateChoiceById(choicesLiveData.value!![2].id,choicesLiveData.value!![2].choiceTitle,choicesLiveData.value!![2].isTrue)
//            repository.updateChoiceById(choicesLiveData.value!![3].id,choicesLiveData.value!![3].choiceTitle,choicesLiveData.value!![3].isTrue)
//
//        }

        runBlocking {
            repository.updateQuestionById(questionLiveData.value?.id!!,questionLiveData.value?.questionTitle!!)
            repository.updateChoiceById(choicesLiveData.value!![0].id,choicesLiveData.value!![0].choiceTitle,choicesLiveData.value!![0].isTrue)
            repository.updateChoiceById(choicesLiveData.value!![1].id,choicesLiveData.value!![1].choiceTitle,choicesLiveData.value!![1].isTrue)
            repository.updateChoiceById(choicesLiveData.value!![2].id,choicesLiveData.value!![2].choiceTitle,choicesLiveData.value!![2].isTrue)
            repository.updateChoiceById(choicesLiveData.value!![3].id,choicesLiveData.value!![3].choiceTitle,choicesLiveData.value!![3].isTrue)

        }
    }

    fun updateAll(newQuestionTitle:String,newChoice1Title:String,newChoice2Title:String,newChoice3Title:String,newChoice4Title:String,newIsChoice1Correct:Boolean,newIsChoice2Correct:Boolean,newIsChoice3Correct:Boolean,newIsChoice4Correct:Boolean){
        questionLiveData.value?.questionTitle = newQuestionTitle
        choicesLiveData.value!![0].choiceTitle = newChoice1Title
        choicesLiveData.value!![1].choiceTitle = newChoice2Title
        choicesLiveData.value!![2].choiceTitle = newChoice3Title
        choicesLiveData.value!![3].choiceTitle = newChoice4Title
        choicesLiveData.value!![0].isTrue = newIsChoice1Correct
        choicesLiveData.value!![1].isTrue = newIsChoice2Correct
        choicesLiveData.value!![2].isTrue = newIsChoice3Correct
        choicesLiveData.value!![3].isTrue = newIsChoice4Correct

        saveToDB()
    }


    fun fetchFromDatabase() {

//        question_title = question.value?.questionTitle
//        choice1 = choices.value?.get(0)?.choiceTitle
//        choice2 = choices.value?.get(1)?.choiceTitle
//        choice3 = choices.value?.get(2)?.choiceTitle
//        choice4 = choices.value?.get(3)?.choiceTitle
//        is_choice1_correct = choices.value?.get(0)?.isTrue!!
//        is_choice2_correct = choices.value?.get(1)?.isTrue!!
//        is_choice3_correct = choices.value?.get(2)?.isTrue!!
//        is_choice4_correct = choices.value?.get(3)?.isTrue!!
//
//        questionLiveData.postValue(question.value)
//        choicesLiveData.postValue(choices.value)
    }
}
