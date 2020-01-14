package com.example.qayourself.ui.Fragment.UI_Play

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.qayourself.R
import com.example.qayourself.ViewModel.PlayingViewModel

class PlayingFragment : Fragment() {

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
        viewModel = ViewModelProviders.of(this).get(PlayingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
