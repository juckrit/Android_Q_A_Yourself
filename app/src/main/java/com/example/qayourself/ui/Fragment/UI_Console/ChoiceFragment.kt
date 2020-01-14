package com.example.qayourself.ui.Fragment.UI_Console

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.qayourself.R
import com.example.qayourself.ViewModel.ChoiceViewModel
import kotlinx.android.synthetic.main.console_choice_fragment.view.*
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.qayourself.ViewModelFactory.ViewModelFactory


class ChoiceFragment : Fragment() {

    var question_id: Long = 0L
    var isChoice1_correct: Boolean = true
    var isChoice2_correct: Boolean = false
    var isChoice3_correct: Boolean = false
    var isChoice4_correct: Boolean = false
    var c1Title: String = ""
    var c2Title: String = ""
    var c3Title: String = ""
    var c4Title: String = ""

    companion object {
        fun newInstance() = ChoiceFragment()
    }

    private lateinit var viewModel: ChoiceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.console_choice_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { arguments ->
            val args =
                ChoiceFragmentArgs.fromBundle(arguments)
            question_id = args.questionId
            viewModel = ViewModelProviders.of(this, ViewModelFactory(context!!, question_id))
                .get(ChoiceViewModel::class.java)

        }

        viewModel.getQuestionLiveData().observe(this, Observer {
            view.tv_question_title.text = it.questionTitle
        })

        val items = arrayOf("True", "False")
        val adapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_dropdown_item, items)
        view.spinner1.setAdapter(adapter)
        view.spinner2.setAdapter(adapter)
        view.spinner3.setAdapter(adapter)
        view.spinner4.setAdapter(adapter)
        view.spinner1.setSelection(0);
        view.spinner2.setSelection(1);
        view.spinner3.setSelection(1);
        view.spinner4.setSelection(1);
        view.tv_question_id.text = question_id.toString()
        view.tv_question_title.text = question_id.toString()

        view.btn_save.setOnClickListener {
            saveChoices()
        }
    }

    fun saveChoices() {
        isChoice1_correct = view?.spinner1?.getSelectedItem().toString().equals("true",true)
        isChoice2_correct = view?.spinner2?.getSelectedItem().toString().equals("true",true)
        isChoice3_correct = view?.spinner3?.getSelectedItem().toString().equals("true",true)
        isChoice4_correct = view?.spinner4?.getSelectedItem().toString().equals("true",true)

        c1Title = view?.et_choice1.toString()
        c2Title = view?.et_choice1.toString()
        c3Title = view?.et_choice1.toString()
        c4Title = view?.et_choice1.toString()

        viewModel.updateAllChoices(c1Title,c2Title,c3Title,c4Title,isChoice1_correct,isChoice2_correct,isChoice3_correct,isChoice4_correct)

        this.findNavController().navigate(R.id.action_choiceFragment_to_mainFragment)

    }


}
