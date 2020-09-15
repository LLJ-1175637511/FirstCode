package com.example.fragmenttest.fragment_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragmenttest.R
import com.example.fragmenttest.fragmentDisplay.OneFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_changeFragment.setOnClickListener {
            replaceFragment(OneFragment())
        }
        replaceFragment(LifeCycle())
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.main_fragment,fragment)
        transaction.commit()
    }
}
