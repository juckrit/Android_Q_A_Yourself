package com.example.qayourself.ui.Fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.qayourself.R
import com.example.qayourself.ViewModel.ChoiceViewModel
import kotlinx.android.synthetic.main.choice_fragment.view.*
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import com.example.qayourself.ViewModelFactory.ViewModelFactory


class ChoiceFragment : Fragment() {

    var question_id: Long = 0L

    companion object {
        fun newInstance() = ChoiceFragment()
    }

    private lateinit var viewModel: ChoiceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.choice_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { arguments ->
            val args = ChoiceFragmentArgs.fromBundle(arguments)
            question_id = args.questionId
            viewModel = ViewModelProviders.of(this,ViewModelFactory(context!!,question_id)).get(ChoiceViewModel::class.java)

        }

        viewModel.getQuestionLiveData().observe(this, Observer {
            view.tv_question_title.text = it.questionTitle
        })

        //create a list of items for the spinner.
        val items = arrayOf("True", "False")
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        val adapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_dropdown_item, items)
        //set the spinners adapter to the previously created one.
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
    }


}
