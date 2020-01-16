package com.example.qayourself.ui.Fragment.UI_Play

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qayourself.R
import com.example.qayourself.Room.Question
import com.example.qayourself.ViewModel.AllQuestionGroupViewModel
import com.example.qayourself.adapter.PlayAllQuestionGroupAdapter
import kotlinx.android.synthetic.main.console_all_question_fragment.recycleview
import kotlinx.android.synthetic.main.play_all_question_fragment.*
import java.util.*
import kotlin.Comparator

class PlayingAllQuestionFragment : Fragment() {

    companion object {
        fun newInstance() = PlayingAllQuestionFragment()
    }

    private lateinit var viewModel: AllQuestionGroupViewModel
    lateinit var dataList:List<Question>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        return inflater.inflate(R.layout.play_all_question_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(AllQuestionGroupViewModel::class.java)


        val adapter = PlayAllQuestionGroupAdapter(context!!, mutableListOf())
        recycleview.layoutManager = LinearLayoutManager(context!!)
        recycleview.adapter = adapter

        viewModel.getAllQuestionLiveData().observe(this, Observer { it ->
            dataList = sortAllQuestionByIdDesc(it)
            adapter.updateQuestions(dataList)
        })

        spinner_sort.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position){
                    0->{
                        dataList = sortAllQuestionByIdAsc(dataList)
                        adapter.updateQuestions(dataList)
                    }
                    1->{
                        dataList = sortAllQuestionByIdDesc(dataList)
                        adapter.updateQuestions(dataList)
                    }
                    2->{
                        dataList = sortAllQuestionByNameDesc(dataList)
                        adapter.updateQuestions(dataList)
                    }
                    3->{
                        dataList = sortAllQuestionByNameAsc(dataList)
                        adapter.updateQuestions(dataList)
                    }
                    4->{
                        dataList = sortAllQuestionByViewAsc(dataList)
                        adapter.updateQuestions(dataList)
                    }
                    5->{
                        dataList = sortAllQuestionByViewDesc(dataList)
                        adapter.updateQuestions(dataList)
                    }
                    6->{
                        dataList = sortAllQuestionByCorrectPercentAsc(dataList)
                        adapter.updateQuestions(dataList)
                    }
                    7->{
                        dataList = sortAllQuestionByCorrectPercentDesc(dataList)
                        adapter.updateQuestions(dataList)
                    }

                }
            }

        }


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

    fun sortAllQuestionByIdAsc(dataList: List<Question>): List<Question> {
        Collections.sort(dataList, object : Comparator<Question> {
            override fun compare(o1: Question?, o2: Question?): Int {
                if (o1!!.id > o2!!.id) {
                    return -1
                } else {
                    return 1
                }
            }

        })
        return dataList
    }
    fun sortAllQuestionByIdDesc(dataList: List<Question>): List<Question> {
        Collections.sort(dataList, object : Comparator<Question> {
            override fun compare(o1: Question?, o2: Question?): Int {
                if (o1!!.id > o2!!.id) {
                    return 1
                } else {
                    return -1
                }
            }

        })
        return dataList
    }
    fun sortAllQuestionByNameAsc(dataList: List<Question>): List<Question> {
        Collections.sort(dataList, object : Comparator<Question> {
            override fun compare(o1: Question?, o2: Question?): Int {
                if (o1!!.questionTitle > o2!!.questionTitle) {
                    return -1
                } else {
                    return 1
                }
            }

        })
        return dataList
    }
    fun sortAllQuestionByNameDesc(dataList: List<Question>): List<Question> {
        Collections.sort(dataList, object : Comparator<Question> {
            override fun compare(o1: Question?, o2: Question?): Int {
                if (o1!!.questionTitle > o2!!.questionTitle) {
                    return 1
                } else {
                    return -1
                }
            }

        })
        return dataList
    }

    fun sortAllQuestionByViewAsc(dataList: List<Question>): List<Question> {
        Collections.sort(dataList, object : Comparator<Question> {
            override fun compare(o1: Question?, o2: Question?): Int {
                if (o1!!.totalView > o2!!.totalView) {
                    return -1
                } else {
                    return 1
                }
            }

        })
        return dataList
    }
    fun sortAllQuestionByViewDesc(dataList: List<Question>): List<Question> {
        Collections.sort(dataList, object : Comparator<Question> {
            override fun compare(o1: Question?, o2: Question?): Int {
                if (o1!!.totalView > o2!!.totalView) {
                    return 1
                } else {
                    return -1
                }
            }

        })
        return dataList
    }
    fun sortAllQuestionByCorrectPercentAsc(dataList: List<Question>): List<Question> {
        Collections.sort(dataList, object : Comparator<Question> {
            override fun compare(o1: Question?, o2: Question?): Int {
                if (o1!!.correctPercent > o2!!.correctPercent) {
                    return -1
                } else {
                    return 1
                }
            }

        })
        return dataList
    }
    fun sortAllQuestionByCorrectPercentDesc(dataList: List<Question>): List<Question> {
        Collections.sort(dataList, object : Comparator<Question> {
            override fun compare(o1: Question?, o2: Question?): Int {
                if (o1!!.correctPercent > o2!!.correctPercent) {
                    return 1
                } else {
                    return -1
                }
            }

        })
        return dataList
    }

}
