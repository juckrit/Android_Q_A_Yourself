package com.example.qayourself.ui.Fragment.UI_Console

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

import com.example.qayourself.R
import com.example.qayourself.ViewModel.EditViewModel
import com.example.qayourself.ViewModelFactory.ViewModelFactory
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

        setSpinner()
        setViewModel()
        setListener()
    }

    private fun setListener() {
        btn_update?.setOnClickListener {
            val newQuestionTitle = et_question_title.text.toString()

            val newChoice1Title = et_choice1.text.toString()
            val newChoice2Title = et_choice2.text.toString()
            val newChoice3Title = et_choice3.text.toString()
            val newChoice4Title = et_choice4.text.toString()


            var newIsChoice1Correct = spinner1?.getSelectedItem().toString().equals("true", true)
            var newIsChoice2Correct = spinner2?.getSelectedItem().toString().equals("true", true)
            var newIsChoice3Correct = spinner3?.getSelectedItem().toString().equals("true", true)
            var newIsChoice4Correct = spinner4?.getSelectedItem().toString().equals("true", true)



            viewModel.updateAll(newQuestionTitle,newChoice1Title,newChoice2Title,newChoice3Title,newChoice4Title,newIsChoice1Correct,newIsChoice2Correct,newIsChoice3Correct,newIsChoice4Correct)
            it.findNavController().navigate(R.id.action_editFragment_to_allQuestionFragment)

        }
    }

    private fun setViewModel() {
        val questionId_forEdit = args.questionIdForEdit
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

            viewModel.choice1 = it[0].choiceTitle
            viewModel.choice2 = it[1].choiceTitle
            viewModel.choice3 = it[2].choiceTitle
            viewModel.choice4 = it[3].choiceTitle
        })
    }

    fun setSpinner() {
        adapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_dropdown_item, items)
        spinner1?.setAdapter(adapter)
        spinner2?.setAdapter(adapter)
        spinner3?.setAdapter(adapter)
        spinner4?.setAdapter(adapter)


    }

}
