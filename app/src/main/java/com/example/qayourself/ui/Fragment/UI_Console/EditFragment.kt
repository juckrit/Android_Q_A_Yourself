package com.example.qayourself.ui.Fragment.UI_Console

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs

import com.example.qayourself.R
import com.example.qayourself.ViewModel.EditViewModel
import com.example.qayourself.ViewModelFactory.ViewModelFactory
import kotlinx.android.synthetic.main.console_choice_fragment.view.*
import kotlinx.android.synthetic.main.console_edit_fragment.*

class EditFragment : Fragment() {

    val items = arrayOf("True", "False")
    lateinit var adapter: ArrayAdapter<String>


    companion object {
        fun newInstance() = EditFragment()
    }

    private lateinit var viewModel: EditViewModel
    val args by navArgs<EditFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.console_edit_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val questionId_forEdit = args.questionIdForEdit
        adapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_dropdown_item, items)

        view.spinner1.setAdapter(adapter)
        view.spinner2.setAdapter(adapter)
        view.spinner3.setAdapter(adapter)
        view.spinner4.setAdapter(adapter)

        viewModel = ViewModelProviders.of(this, ViewModelFactory(context!!, questionId_forEdit))
            .get(EditViewModel::class.java)
        viewModel.getQuestionLiveData().observe(this, Observer {
            et_question_title.setText(it.questionTitle)
        })
        viewModel.getChoicesLiveData().observe(this, Observer {
            et_choice1.setText(it[0].choiceTitle)
            et_choice2.setText(it[1].choiceTitle)
            et_choice3.setText(it[2].choiceTitle)
            et_choice4.setText(it[3].choiceTitle)
            val isChoice1Correct = it[0].isTrue
            val isChoice2Correct = it[1].isTrue
            val isChoice3Correct = it[2].isTrue
            val isChoice4Correct = it[3].isTrue
            spinner1.setSelection(if (isChoice1Correct) 0 else 1)
            spinner2.setSelection(if (isChoice2Correct) 0 else 1)
            spinner3.setSelection(if (isChoice3Correct) 0 else 1)
            spinner4.setSelection(if (isChoice4Correct) 0 else 1)
        })


    }

}
