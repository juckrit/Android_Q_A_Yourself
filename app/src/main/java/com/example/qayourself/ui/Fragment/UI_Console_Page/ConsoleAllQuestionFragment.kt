package com.example.qayourself.ui.Fragment.UI_Console_Page

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qayourself.R
import com.example.qayourself.Util.ItemDragListener
import com.example.qayourself.Util.ItemTouchHelperCallback
import com.example.qayourself.ViewModel.AllQuestionGroupViewModel
import com.example.qayourself.adapter.ConsoleAllQuestionGroupAdapter
import kotlinx.android.synthetic.main.console_all_question_fragment.*

class ConsoleAllQuestionFragment : Fragment(), ItemDragListener {


    companion object {
        fun newInstance() = ConsoleAllQuestionFragment()
    }

    private lateinit var viewModel: AllQuestionGroupViewModel
    private lateinit var adapter: ConsoleAllQuestionGroupAdapter
    private lateinit var itemTouchHelper: ItemTouchHelper

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

        setupViewmodel()
        setupFloatingActionButtonListener()
        setupAdapterAndRecycleview()
        observeViewModel()
        setupItemTouchHelper()


    }

    private fun setupAdapterAndRecycleview() {
        adapter = ConsoleAllQuestionGroupAdapter(context!!, mutableListOf(),this)
        recycleview.layoutManager = LinearLayoutManager(context!!)
        recycleview.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.getAllQuestionLiveData().observe(this, Observer { it ->
            adapter.updateQuestions(it)
        })
    }

    private fun setupFloatingActionButtonListener() {
        floatingActionButton.setOnClickListener { buttonView ->
            buttonView
                .findNavController()
                .navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    private fun setupViewmodel() {
        viewModel = ViewModelProviders.of(this).get(AllQuestionGroupViewModel::class.java)
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

    fun setupItemTouchHelper() {
        itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(adapter))
        itemTouchHelper.attachToRecyclerView(recycleview)
    }

    override fun onItemDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
    }


}
