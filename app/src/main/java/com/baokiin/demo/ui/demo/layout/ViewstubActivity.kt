package com.baokiin.demo.ui.demo.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewStub
import com.baokiin.demo.R
import com.baokiin.demo.ui.demo.DemoAdapter

class ViewstubActivity : AppCompatActivity() {
    val adapter by lazy { DemoAdapter() }
    companion object{
        const val TYPE = "TYPE"
    }
    val type:String? by lazy { intent.getStringExtra(TYPE) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val timeStart = System.currentTimeMillis()
        setContentView(R.layout.activity_viewstub)
        Log.d("quocbao","Constraint-end: ${System.currentTimeMillis() - timeStart}")

        if (type == "5") findViewById<View>(R.id.view1).visibility = View.VISIBLE
        else findViewById<View>(R.id.view2).visibility = View.VISIBLE

    }
}