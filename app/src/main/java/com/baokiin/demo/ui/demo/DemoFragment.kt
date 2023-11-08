package com.baokiin.demo.ui.demo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.baokiin.demo.R
import com.baokiin.demo.ui.demo.layout.*

class DemoFragment : Fragment(), View.OnClickListener {
    lateinit var viewItem: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewItem = inflater.inflate(R.layout.demo_fragment, container, false)
        initView()
        return viewItem
    }

    private fun initView() {
        viewItem.findViewById<Button>(R.id.button).setOnClickListener(this)
        viewItem.findViewById<Button>(R.id.button2).setOnClickListener(this)
        viewItem.findViewById<Button>(R.id.button3).setOnClickListener(this)
        viewItem.findViewById<Button>(R.id.button4).setOnClickListener(this)
        viewItem.findViewById<Button>(R.id.viewstub1).setOnClickListener(this)
        viewItem.findViewById<Button>(R.id.viewstub2).setOnClickListener(this)
        viewItem.findViewById<Button>(R.id.skipframe).setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        val classActivity = when (p0?.tag) {
            "1" -> LinearLayoutActivity::class.java
            "2" -> ConstraintActivity::class.java
            "3" -> LinearLayout2Activity::class.java
            "4" -> LinearLayout3Activity::class.java
            "5" -> ViewstubActivity::class.java
            "6" -> ViewstubActivity::class.java
            else -> SkipFrameLayoutActivity::class.java
        }
        val intentLayout = Intent(requireActivity(), classActivity)
        intentLayout.putExtra(ViewstubActivity.TYPE,p0?.tag.toString())
        requireActivity().startActivity(intentLayout)
    }

}