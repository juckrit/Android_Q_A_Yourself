package com.example.qayourself.ui.Fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.qayourself.R
import com.example.qayourself.ViewModel.AllQuestionViewModel

class AllQuestionFragment : Fragment() {

    companion object {
        fun newInstance() = AllQuestionFragment()
    }

    private lateinit var viewModel: AllQuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.all_question_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AllQuestionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
