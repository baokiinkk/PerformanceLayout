package com.baokiin.demo.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baokiin.demo.R
import com.baokiin.demo.ui.detail.DetailActivity

class HomeMotionFragment : Fragment() {
    lateinit var viewFragment: View
    val adapter1 by lazy { AdapterMain() }
    val adapter2 by lazy { AdapterMain() }
    val adapter3 by lazy { AdapterMain() }
    val concatAdapter by lazy {
        ConcatAdapter(
            ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(),
            adapter1, adapter2,adapter3
        )
    }
    val recycleview by lazy { viewFragment.findViewById<RecyclerView>(R.id.recycleview) }
    val search by lazy { viewFragment.findViewById<SearchView>(R.id.search) }
    val textView by lazy { viewFragment.findViewById<TextView>(R.id.textView) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewFragment = inflater.inflate(R.layout.home_motion_fragment, container, false)
        initView()
        return viewFragment
    }

    private fun initView() {
        adapter1.updateList(getData("CHỨC NĂNG 1"))
        adapter2.updateList(getData("CHỨC NĂNG 2"))
        adapter3.updateList(getData("CHỨC NĂNG 3"))
        recycleview.adapter = concatAdapter
        recycleview.layoutManager = getLayoutManager()
        search.setOnClickListener {
            val intent = Intent(requireActivity(), DetailActivity::class.java)
            val p1: androidx.core.util.Pair<View, String> =
                androidx.core.util.Pair(it as View, it.transitionName)
            val p2: androidx.core.util.Pair<View, String> =
                androidx.core.util.Pair(recycleview as View, recycleview.transitionName)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(), p1, p2)
            requireActivity().startActivity(intent, options.toBundle())
        }
    }

    private fun getLayoutManager() =
        GridLayoutManager(requireActivity(), 4).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (concatAdapter.getItemViewType(position)) {
                        AdapterMain.TITLE-> 4
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