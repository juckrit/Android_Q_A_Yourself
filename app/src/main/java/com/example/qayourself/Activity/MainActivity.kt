package com.example.qayourself.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import com.example.qayourself.R
import com.example.qayourself.ui.Fragment.UI_Play.AllQuestionFragmentDirections

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.tab_menu ->{
               val directions = AllQuestionFragmentDirections.actionAllQuestionFragment2ToConsoleActivity()
                findNavController(R.id.nav_host_fragment).navigate(directions)
            }

        }
        return super.onOptionsItemSelected(item)
    }

}
