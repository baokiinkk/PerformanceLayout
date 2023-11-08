package com.baokiin.demo.ui.demo.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.baokiin.demo.R
import com.baokiin.demo.ui.demo.DemoAdapter

class LinearLayoutActivity : AppCompatActivity() {
    val adapter by lazy { DemoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val timeStart = System.currentTimeMillis()
        setContentView(R.layout.activity_linear_layout)
        Log.d("quocbao","linear-end: ${System.currentTimeMillis() - timeStart}")
    }
}