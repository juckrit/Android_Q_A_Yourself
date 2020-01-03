package com.example.qayourself.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qayourself.R
import com.example.qayourself.ui.Fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
