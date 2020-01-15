package com.example.qayourself.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qayourself.Room.Choice
import com.example.qayourself.Room.Question
import com.example.qayourself.Room.RoomRepository
import kotlinx.coroutines.launch

class ChoiceViewModel(val question_id: Long) : ViewModel() {
    private var repository: RoomRepository = RoomRepository()

    var choice1 = ""
    var choice2 = ""
    var choice3 = ""
    var choice4 = ""
    var question_title = ""
    var is_choice1_correct = true
    var is_choice2_correct = false
    var is_choice3_correct = false
    var is_choice4_correct = false

    var allChoices = mutableListOf<Choice>()


    private var questionLiveData: LiveData<Question> =
        repository.getQuestionById(question_id)

    fun getQuestionLiveData(): LiveData<Question> {
        return questionLiveData
    }

    fun updateAllChoices(
        choice_title1: String
        , choice_title2: String
        , choice_title3: String
        , choice_title4: String
        , isChoice1Correct: Boolean
        , isChoice2Correct: Boolean
        , isChoice3Correct: Boolean
        , isChoice4Correct: Boolean
    ) {
        this.choice1 = choice_title1
        this.choice2 = choice_title2
        this.choice3 = choice_title3
        this.choice4 = choice_title4
        this.is_choice1_correct = isChoice1Correct
        this.is_choice2_correct = isChoice2Correct
        this.is_choice3_correct = isChoice3Correct
        this.is_choice4_correct = isChoice4Correct

        var c1 = Choice(0, question_id, isChoice1Correct,choice1)
        var c2 = Choice(0, question_id, isChoice2Correct,choice2)
        var c3 = Choice(0, question_id, isChoice3Correct,choice3)
        var c4 = Choice(0, question_id, isChoice4Correct,choice4)

        allChoices.add(c1)
        allChoices.add(c2)
        allChoices.add(c3)
        allChoices.add(c4)

        viewModelScope.launch {
            repository.insertChoice(allChoices)

        }

    }


}



