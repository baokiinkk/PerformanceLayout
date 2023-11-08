package com.baokiin.demo.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.baokiin.demo.R

class AdapterTitle : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listener: ((ImageView, ModelImage) -> Unit)? = null
    private val listData = mutableListOf<Model>()

    companion object {
        const val TYPE = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return CardViewHolder(view)

    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun getItemViewType(position: Int): Int {
        return TYPE
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CardViewHolder).onBind(getItemPosition(position))
    }

    fun updateList(list: MutableList<Model>?) {
        list?.let {
            listData.clear()
            listData.addAll(it)
            notifyItemRangeInserted(0, listData.size)
        }
    }

    fun getItemPosition(pos: Int): ModelImage {
        return listData[pos] as ModelImage
    }

    fun setOnListener(action: (ImageView, ModelImage) -> Unit) {
        this.listener = action
    }

    inner class CardViewHolder(
        val binding: View
    ) : RecyclerView.ViewHolder(binding) {
        val image = binding.findViewById<ImageView>(R.id.image)
        val text = binding.findViewById<TextView>(R.id.text)

        init {
            itemView.setOnClickListener {
                listener?.invoke(image, getItemPosition(adapterPosition))
            }
        }

        fun onBind(
            vhData: ModelImage
        ) {
            image.setImageResource(vhData.image)
            image.transitionName = vhData.transaction
            text.text = vhData.id
            Log.d("quocbao","ẩn view kia")

        }
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        Log.d("quocbao","xuất hiện view kia")

    }
}
