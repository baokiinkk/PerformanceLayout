package com.baokiin.demo.ui.detail

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baokiin.demo.R
import com.baokiin.demo.ui.home.*

class DetailActivity : AppCompatActivity() {
    val adapter1 by lazy { AdapterMain() }
    val adapter2 by lazy { AdapterMain() }
    val adapter3 by lazy { AdapterTitle() }
    val recycleview by lazy { findViewById<RecyclerView>(R.id.recycleview) }
    var index = 0
    val concatAdapter by lazy {
        ConcatAdapter(
            ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(),
            adapter3, adapter1, adapter2
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        window.sharedElementEnterTransition =
            TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition);
        adapter1.updateList(getData("CHỨC NĂNG 1"))
        adapter2.updateList(getData("CHỨC NĂNG 2"))
        adapter3.updateList(getDataTitle())
        recycleview.adapter = concatAdapter
        recycleview.layoutManager = getLayoutManager()
        findViewById<View>(R.id.ivBack).setOnClickListener {
            onBackPressed()
        }
    }

    private fun getLayoutManager() =
        GridLayoutManager(this, 4).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (concatAdapter.getItemViewType(position)) {
                        AdapterMain.TITLE,AdapterView.SEARCH,AdapterView.TITLE -> 4
                        AdapterTitle.TYPE -> 1
                        else -> 1
                    }
                }
            }
        }
    private fun getData(title: String): MutableList<Model> {
        val list: MutableList<Model> = mutableListOf()
        list.add(ModelTitle(title))
        for (i in 0..10) {
            list.add(
                ModelImage(
                    R.drawable.hinh3,
                    R.drawable.hinh3.toString(),
                    "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4",
                    i.toString()
                ),
            )
        }
        return list
    }

    fun getDataTitle(): MutableList<Model> {
        val list: MutableList<Model> = mutableListOf()
        for (i in 0..3) {
            list.add(
                ModelImage(
                    R.drawable.hinh1,
                    R.drawable.hinh1.toString(),
                    "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4",
                    i.toString()
                ),
            )
        }
        return list
    }

}