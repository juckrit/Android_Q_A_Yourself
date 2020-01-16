package com.example.qayourself.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.qayourself.R
import com.example.qayourself.Room.Question
import com.example.qayourself.ui.Fragment.UI_Play_Page.PlayingAllQuestionFragmentDirections
import kotlinx.android.synthetic.main.list_of_question.view.*
import java.util.logging.Filter
import java.util.logging.LogRecord

class PlayAllQuestionGroupAdapter(val context: Context, val dataList: MutableList<Question>) :
    RecyclerView.Adapter<PlayAllQuestionGroupAdapter.ViewHolder>()
    , Filterable {




    // Single not-to-be-modified copy of original data in the list.
    var originalList = listOf<Question>()
    // a method-body to invoke when search returns nothing. It can be null.
    private var onNothingFound: (() -> Unit)? = null

    /**
     * Searches a specific item in the list and updates adapter.
     * if the search returns empty then onNothingFound callback is invoked if provided which can be used to update UI
     * @param s the search query or text. It can be null.
     * @param onNothingFound a method-body to invoke when search returns nothing. It can be null.
     */
    fun search(s: String?, onNothingFound: (() -> Unit)?) {
        this.onNothingFound = onNothingFound
        filter?.filter(s)

    }


    override fun getFilter(): android.widget.Filter? {
        return object : android.widget.Filter() {
            private val filterResults = FilterResults()
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                dataList.clear()
                if (constraint.isNullOrBlank()) {
                    dataList.addAll(originalList)
                } else {
                    val searchResults = originalList.filter { it.questionTitle.contains(constraint) }
                    dataList.addAll(searchResults)
                }
                return filterResults.also {
                    it.values = dataList
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                // no need to use "results" filtered list provided by this method.
                if (dataList.isNullOrEmpty())
                    onNothingFound?.invoke()
                notifyDataSetChanged()

            }
        }
    }

    interface Searchable {
        /** This method will allow to specify a search string to compare against
        your search this can be anything depending on your use case.
         */
        fun getSearchCriteria(): Question
    }






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

                val action =
                    PlayingAllQuestionFragmentDirections.actionPlayAllQuestionFragmentToPlayingFragment(
                        questionId = question.id
                    )

                it.findNavController()
                    .navigate(action)
            }
        }
    }
}