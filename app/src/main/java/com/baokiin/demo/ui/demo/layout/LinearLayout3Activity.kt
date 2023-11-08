package com.baokiin.demo.ui.demo.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.baokiin.demo.R
import com.baokiin.demo.ui.demo.DemoAdapter

class LinearLayout3Activity : AppCompatActivity() {
    val adapter by lazy { DemoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val timeStart = System.currentTimeMillis()
        setContentView(R.layout.activity_linear_layout3)
        Log.d("quocbao","merge-end: ${System.currentTimeMillis() - timeStart}")
    }
}