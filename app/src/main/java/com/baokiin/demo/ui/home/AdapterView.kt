package com.baokiin.demo.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.baokiin.demo.R

class AdapterView(val type:Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listener: ((SearchView, String) -> Unit)? = null

    companion object {
        const val SEARCH = 4
        const val TITLE = 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = if(type == SEARCH) R.layout.item_search else R.layout.item_title_home
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return CardViewHolder(view)

    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun getItemViewType(position: Int): Int {
        return type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    fun setOnListener(action: (SearchView, String) -> Unit) {
        this.listener = action
    }

    inner class CardViewHolder(
        val binding: View
    ) : RecyclerView.ViewHolder(binding) {
        val search = binding.findViewById<SearchView>(R.id.search)

        init {
            itemView.setOnClickListener {
                listener?.invoke(search, search.transitionName)
            }
        }

    }


}
