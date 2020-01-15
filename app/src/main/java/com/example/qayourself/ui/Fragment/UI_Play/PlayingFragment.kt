package com.example.qayourself.ui.Fragment.UI_Play

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs

import com.example.qayourself.R
import com.example.qayourself.ViewModel.PlayingViewModel
import com.example.qayourself.ViewModelFactory.ViewModelFactory
import com.example.qayourself.ui.Fragment.UI_Console.EditFragmentArgs
import kotlinx.android.synthetic.main.playing_fragment.*

class PlayingFragment : Fragment() {

    var questionId: Long = -1
    val args by navArgs<PlayingFragmentArgs>()


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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        questionId = args.questionId
        viewModel = ViewModelProviders.of(this, ViewModelFactory(context!!, questionId))
            .get(PlayingViewModel::class.java)


        setUp()
    }

    private fun setUp() {
        viewModel.getQuestionLiveData().observe(this, Observer {
            tv_question_title.setText(it.questionTitle)
        })
        viewModel.getChoiceLiveData().observe(this, Observer {
            btn_choice_1.setText(it[0].choiceTitle)
            btn_choice_2.setText(it[1].choiceTitle)
            btn_choice_3.setText(it[2].choiceTitle)
            btn_choice_4.setText(it[3].choiceTitle)
        })
    }

}
