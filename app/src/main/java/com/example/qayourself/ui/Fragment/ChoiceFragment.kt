package com.example.qayourself.ui.Fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.qayourself.R
import com.example.qayourself.ViewModel.ChoiceViewModel

class ChoiceFragment : Fragment() {

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
        viewModel = ViewModelProviders.of(this).get(ChoiceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
