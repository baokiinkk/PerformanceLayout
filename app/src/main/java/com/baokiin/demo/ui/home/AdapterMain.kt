package com.baokiin.demo.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.baokiin.demo.R

class AdapterMain : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listener: ((ImageView, ModelImage) -> Unit)? = null
    private val listData = mutableListOf<Model>()

    companion object {
        const val TITLE = 1
        const val OTHER = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when (viewType) {
            TITLE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_title_func, parent, false)
                return TitleViewHolder(view)
            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
                return CardViewHolder(view)
            }
        }

    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (listData[position]) {
            is ModelTitle -> {
                TITLE
            }
            else -> {
                OTHER
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TITLE -> {
                (holder as TitleViewHolder).onBind(getItemTitlePosition(position))
            }
            else -> {
                (holder as CardViewHolder).onBind(getItemPosition(position))
            }
        }
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

    fun getItemTitlePosition(position: Int): ModelTitle =
        listData[position] as ModelTitle

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
        }
    }

    inner class TitleViewHolder(
        val binding: View
    ) : RecyclerView.ViewHolder(binding) {
        val title = binding.findViewById<TextView>(R.id.title)

        fun onBind(
            vhData: ModelTitle
        ) {
            title.text = vhData.title
        }
    }

}

data class ModelImage(
    @DrawableRes val image: Int,
    val transaction: String,
    val url: String,
    val id: String
) : Model

data class ModelTitle(val title: String) : Model
interface Model
