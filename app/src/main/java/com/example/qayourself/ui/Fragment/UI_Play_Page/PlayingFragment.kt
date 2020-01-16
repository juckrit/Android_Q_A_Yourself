package com.example.qayourself.ui.Fragment.UI_Play_Page

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs

import com.example.qayourself.R
import com.example.qayourself.ViewModel.PlayingViewModel
import com.example.qayourself.ViewModelFactory.ViewModelFactory
import kotlinx.android.synthetic.main.playing_fragment.*

class PlayingFragment : Fragment() {

    var questionId: Long = -1
    val args by navArgs<PlayingFragmentArgs>()
    var correctedChoicePosition = -1


    companion object {
        fun newInstance() = PlayingFragment()
    }

    private lateinit var viewModel: PlayingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.playing_fragment, container, false)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.clear()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        questionId = args.questionId
        viewModel = ViewModelProviders.of(this, ViewModelFactory(context!!, questionId))
            .get(PlayingViewModel::class.java)


        setUp()
        addListenerToView()
    }


    private fun addListenerToView() {
        btn_choice_1.setOnClickListener {
            sendAnswer(1)
        }
        btn_choice_2.setOnClickListener {
            sendAnswer(2)
        }
        btn_choice_3.setOnClickListener {
            sendAnswer(3)
        }
        btn_choice_4.setOnClickListener {
            sendAnswer(4)
        }
    }

    private fun setUp() {
        viewModel.getQuestionLiveData().observe(this, Observer {
            tv_question_title.setText(it.questionTitle)
            tv_total_view.setText(it.totalView.minus(1).toString())
            tv_total_correct.setText(it.totalCorrect.toString())
            tv_total_incorrect.setText(it.totalIncorrect.toString())
            tv_correct_percent.setText(it.correctPercent.toString())


        })
        viewModel.getChoiceLiveData().observe(this, Observer {
            btn_choice_1.setText(it[0].choiceTitle)
            btn_choice_2.setText(it[1].choiceTitle)
            btn_choice_3.setText(it[2].choiceTitle)
            btn_choice_4.setText(it[3].choiceTitle)
            it.forEachIndexed { index, element ->
                if (element.isTrue){
                    correctedChoicePosition = index+1
                }
            }
        })
    }

    private fun sendAnswer(choicePosition:Int){
        if (choicePosition == correctedChoicePosition){
            viewModel.updateQuestionWhenCorrectById()

        }else{
            viewModel.updateQuestionWhenIncorrectById()

        }
    }

}
