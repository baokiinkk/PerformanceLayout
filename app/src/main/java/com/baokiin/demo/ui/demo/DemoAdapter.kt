package com.baokiin.demo.ui.demo

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.baokiin.demo.R

class DemoAdapter() : RecyclerView.Adapter<DemoAdapter.Viewholder>() {
    companion object{
        const val LINEAR = 1
        const val LINEAR2 = 2
        const val CONSTRAINT = 3
        const val CONSTRAINT2 = 4
        const val OTHER = 5
    }
    private val listData = mutableListOf<ModelData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val layout = when(viewType){
            LINEAR->R.layout.item_layout_linear
            LINEAR2->R.layout.item_layout_linear2
            CONSTRAINT->R.layout.item_layout_constraint
            CONSTRAINT2->R.layout.item_layout_constraint2
            else->R.layout.item_layout_linear3
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(listData[position].type){
            "LinearLayout"-> LINEAR
            "ConstrainLayout"-> CONSTRAINT
            "LinearLayout2"-> LINEAR2
            "Contraint2"-> CONSTRAINT2
            else-> OTHER
        }
    }
    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val data = listData[position]
        holder.onBind(data)
    }

    fun updateList(list:MutableList<ModelData>){
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }

    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(item:ModelData){
            itemView.setBackgroundColor(if(adapterPosition % 2 == 0) Color.CYAN else Color.GRAY)
        }
    }
}

data class ModelData(val data: String,val type:String?)
