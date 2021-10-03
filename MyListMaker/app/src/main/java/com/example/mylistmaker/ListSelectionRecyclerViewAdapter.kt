package com.example.mylistmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ListSelectionRecyclerViewAdapter(val lists: ArrayList<TaskList>,
                                       val clickListener: ListSelectionRecyclerViewClickListener) :
    RecyclerView.Adapter<ListSelectionViewHolder>() {

    //mock list titles
//    val listTitles = arrayOf("Shopping List", "Chores", "Android Tutorials")



    interface ListSelectionRecyclerViewClickListener {
        fun listItemClicked(list: TaskList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_selection_view_holder,
                parent,
                false)
        return ListSelectionViewHolder(view)

    }

    fun addList(list: TaskList) {
        lists.add(list)
        notifyItemInserted(lists.size-1)
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position:
    Int) {
        holder.listPosition.text = (position + 1).toString()
        holder.listTitle.text = lists[position].name
        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(lists[position])
        }
    }

    //determines how many items the RecyclerView
    override fun getItemCount(): Int {
        return lists.size
    }
}