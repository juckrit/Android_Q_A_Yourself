package com.example.qayourself.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.qayourself.R
import com.example.qayourself.Room.Question
import com.example.qayourself.Util.ItemDragListener
import com.example.qayourself.Util.ItemSelectedListener
import com.example.qayourself.Util.ItemTouchHelperListener
import com.example.qayourself.ui.Fragment.UI_Console_Page.ConsoleAllQuestionFragment
import com.example.qayourself.ui.Fragment.UI_Console_Page.ConsoleAllQuestionFragmentDirections
import kotlinx.android.synthetic.main.list_of_question.view.*
import kotlinx.android.synthetic.main.list_of_question.view.tv_correctPercent
import kotlinx.android.synthetic.main.list_of_question.view.tv_title
import kotlinx.android.synthetic.main.list_of_question.view.tv_totalVIew
import kotlinx.android.synthetic.main.list_of_question_with_rearrage.view.*
import java.util.*

class ConsoleAllQuestionGroupAdapter(
    val context: Context,
    val dataList: MutableList<Question>,
    private val itemDragListener: ItemDragListener
) :
    RecyclerView.Adapter<ConsoleAllQuestionGroupAdapter.ViewHolder>()
    , ItemTouchHelperListener {

    override fun onItemDismiss(viewHolder: RecyclerView.ViewHolder, position: Int) {
        ConsoleAllQuestionFragment.getViewModel().deleteQuestionById(dataList[position].id)
        dataList.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onItemMove(
        recyclerView: RecyclerView,
        fromPosition: Int,
        toPosition: Int
    ): Boolean {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(dataList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(dataList, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    private val inflater = LayoutInflater.from(context)

    fun updateQuestions(questions: List<Question>) {
        this.dataList.clear()
        this.dataList.addAll(questions)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.list_of_question_with_rearrage, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(dataList[position])

    }


    inner class ViewHolder(val itv: View) :
        RecyclerView.ViewHolder(itv), ItemSelectedListener {


        fun binding(question: Question) {
            itv.tv_title.text = question.questionTitle
            itv.tv_totalVIew.text = question.totalView.toString()
            itv.tv_correctPercent.text = question.correctPercent.toString()
            itv.setOnClickListener {

                val action =
                    ConsoleAllQuestionFragmentDirections.actionAllQuestionFragmentToEditFragment(
                        questionIdForEdit = question.id
                    )

                it.findNavController()
                    .navigate(action)


            }
            itv.iv_handle.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    itemDragListener.onItemDrag(this)
                }
                false
            }
        }


        override fun onItemSelected() {
            itv.listItemContainer.setBackgroundColor(
                ContextCompat.getColor(
                    itv.context,
                    R.color.colorSelectedItem
                )
            )
        }

        override fun onItemCleared() {
            itv.listItemContainer.setBackgroundColor(0)
        }
    }
}