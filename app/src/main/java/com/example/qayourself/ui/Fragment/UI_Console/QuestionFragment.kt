package com.example.qayourself.ui.Fragment.UI_Console

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController

import com.example.qayourself.R
import com.example.qayourself.Util.showToast
import com.example.qayourself.ViewModel.QuestionViewModel
import kotlinx.android.synthetic.main.console_question_fragment.*

class QuestionFragment : Fragment() {

    companion object {
        fun newInstance() = QuestionFragment()
    }

    private lateinit var viewModel: QuestionViewModel

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.console_question_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)

        viewModel.getSaveLiveData().observe(this, Observer { question_id->
            if (question_id!=0L){
                val action =
                    QuestionFragmentDirections.actionMainFragmentToChoiceFragment(
                        questionId = question_id
                    )
                view.findNavController()
                    .navigate(action)


            }else{
                showToast(context,"กรุณากรอกชื่อคำถาม")
            }
        })

            viewModel.getQuestionLiveData().observe(this, Observer {
            tv_preview_title.text = it.questionTitle
            tv_preview_view_count.text = it.totalView.toString()
            tv_preview_correct.text = it.totalCorrect.toString()
            tv_preview_incorrect.text = it.totalIncorrect.toString()
            tv_preview_correct_percent.text = it.correctPercent.toString()
        })

        et_question.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.questionTitleFilled(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        et_view_count.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                var value = 0
                if (s.toString().isNullOrBlank()) {
                    value = 0
                } else {
                    value = s.toString().toInt()
                }
                viewModel.viewCountFilled(value)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        et_total_correct.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                var value = 0
                if (s.toString().isNullOrBlank()) {
                    value = 0
                } else {
                    value = s.toString().toInt()
                }
                viewModel.correctCountFilled(value)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        et_total_incorrect . addTextChangedListener (object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                var value = 0
                if (s.toString().isNullOrBlank()) {
                    value = 0
                } else {
                    value = s.toString().toInt()
                }
                viewModel.incorrectCountFilled(value)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        btn_add.setOnClickListener {
            viewModel.saveQuestion()

        }

    }

//    override fun onDestroy() {
//        super.onDestroy()
//        viewModel.stopCoroutineJob()
//    }

}
