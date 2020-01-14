package com.example.qayourself.ui.Fragment.UI_Console

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qayourself.R
import com.example.qayourself.ViewModel.AllQuestionGroupViewModel
import com.example.qayourself.adapter.ConsoleAllQuestionGroupAdapter
import kotlinx.android.synthetic.main.console_all_question_fragment.*

class ConsoleAllQuestionFragment : Fragment() {

    companion object {
        fun newInstance() = ConsoleAllQuestionFragment()
    }

    private lateinit var viewModel: AllQuestionGroupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        return inflater.inflate(R.layout.console_all_question_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(AllQuestionGroupViewModel::class.java)


        floatingActionButton.setOnClickListener { buttonView ->
            buttonView
                .findNavController()
                .navigate(R.id.action_firstFragment_to_secondFragment)
        }

        val adapter = ConsoleAllQuestionGroupAdapter(context!!, mutableListOf())
        recycleview.layoutManager = LinearLayoutManager(context!!)
        recycleview.adapter = adapter

        viewModel.getAllQuestionLiveData().observe(this, Observer { it ->
            adapter.updateQuestions(it)
        })



    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

}
