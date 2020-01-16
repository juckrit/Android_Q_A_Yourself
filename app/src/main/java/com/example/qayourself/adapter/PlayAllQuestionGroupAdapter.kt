package com.example.qayourself.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.qayourself.R
import com.example.qayourself.Room.Question
import com.example.qayourself.ui.Fragment.UI_Play_Page.PlayingAllQuestionFragmentDirections
import kotlinx.android.synthetic.main.list_of_question.view.*

class PlayAllQuestionGroupAdapter(val context: Context, val dataList: MutableList<Question>) :
    RecyclerView.Adapter<PlayAllQuestionGroupAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    fun updateQuestions(questions: List<Question>) {
        this.dataList.clear()
        this.dataList.addAll(questions)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.list_of_question, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(dataList[position])

    }


    class ViewHolder(val itv: View) :
        RecyclerView.ViewHolder(itv) {
        fun binding(question: Question) {
            itv.tv_title.text = question.questionTitle
            itv.tv_totalVIew.text = question.totalView.toString()
            itv.tv_correctPercent.text = question.correctPercent.toString()
            itv.setOnClickListener {

                val action = PlayingAllQuestionFragmentDirections.actionPlayAllQuestionFragmentToPlayingFragment(
                    questionId =question.id
                )

                it.findNavController()
                    .navigate(action)
            }
        }
    }
}