package com.baokiin.demo.ui.demo.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.baokiin.demo.R
import com.baokiin.demo.ui.demo.DemoAdapter

class ConstraintActivity : AppCompatActivity() {
    val adapter by lazy { DemoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val timeStart = System.currentTimeMillis()
        setContentView(R.layout.activity_constaint_layout)
        Log.d("quocbao","Constraint-end: ${System.currentTimeMillis() - timeStart}")
    }
}