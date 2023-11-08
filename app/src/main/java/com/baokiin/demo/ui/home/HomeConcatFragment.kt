package com.baokiin.demo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baokiin.demo.R

class HomeConcatFragment : Fragment() {
    lateinit var viewFragment: View
    val adapter1 by lazy { AdapterMain() }
    val adapter2 by lazy { AdapterMain() }
    val adapter3 by lazy { AdapterMain() }
    val adapterTitleFunc by lazy { AdapterTitle() }
    val adapterSearch by lazy { AdapterView(AdapterView.SEARCH) }
    val adapterTitle by lazy { AdapterView(AdapterView.TITLE) }
    val concatAdapter by lazy {
        ConcatAdapter(
            ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(),
            adapterTitle,adapterSearch,adapterTitleFunc,adapter1, adapter2,adapter3
        )
    }
    val recycleview by lazy { viewFragment.findViewById<RecyclerView>(R.id.recycleview) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewFragment = inflater.inflate(R.layout.home_concat_fragment, container, false)
        initView()
        return viewFragment
    }

    private fun initView() {
        adapter1.updateList(getData("CHỨC NĂNG 1"))
        adapter2.updateList(getData("CHỨC NĂNG 2"))
        adapter3.updateList(getData("CHỨC NĂNG 3"))
        adapterTitleFunc.updateList(getDataTitle())
        recycleview.adapter = concatAdapter
        recycleview.layoutManager = getLayoutManager()
    }

    private fun getLayoutManager() =
        GridLayoutManager(requireActivity(), 4).apply {
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