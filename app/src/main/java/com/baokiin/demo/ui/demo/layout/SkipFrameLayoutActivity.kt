package com.baokiin.demo.ui.demo.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.baokiin.demo.R
import com.baokiin.demo.ui.demo.DemoSkipAdapter
import com.baokiin.demo.ui.home.AdapterMain
import com.baokiin.demo.ui.home.Model
import com.baokiin.demo.ui.home.ModelImage

class SkipFrameLayoutActivity : AppCompatActivity() {
    val adapter by lazy { DemoSkipAdapter() }
    val recycler by lazy { findViewById<RecyclerView>(R.id.recycleview) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skip_frame_layout)
        recycler.adapter = adapter
        adapter.updateList(getDataTitle())

    }

    fun getDataTitle(): MutableList<Model> {
        val list: MutableList<Model> = mutableListOf()
        for (i in 0..1000) {
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