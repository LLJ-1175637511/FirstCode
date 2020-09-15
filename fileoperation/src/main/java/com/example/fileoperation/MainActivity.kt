package com.example.fileoperation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_et.setText(getData())
        getMySharePreference()
    }

    override fun onDestroy() {
        super.onDestroy()
        val inputStr = main_et.text.trim().toString()
        save(inputStr)
        saveSharePreference()
    }

    private fun save(input: String) {
        try {
            val output = openFileOutput("data", Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(output))
            writer.use {
                it.write(input)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getData():String {
        val str = StringBuilder()
        try {
            val data = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(data))
            reader.use {
                it.forEachLine { txt->
                    str.append(txt)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return str.toString()
    }

    private fun saveSharePreference(){
        //ktx库
//        getSharedPreferences("data", Context.MODE_PRIVATE).edit(true) {
//            putString("", "")
//        }
        val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
        editor.putString("name","llj")
        editor.putString("pwd","666")
        editor.apply()
    }

    private fun getMySharePreference(){
        val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
        val name = prefs.getString("name","")
        val pwd = prefs.getString("pwd","")
        Log.d(TAG,"name:$name \n pwd:$pwd")
    }

    companion object{
        const val TAG = "MainActivity"
    }
}
