package com.example.thefirstcode

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("main", "hello")
        tv.setOnClickListener {
//            toast("hhh")

            //隐式跳转 自定义标签（Category）
//            val intent = Intent("com.llj.activity.act_str")
//            intent.addCategory("android.intent.category.DEFAULT")
//            startActivity(intent)

            //隐式跳转 外部网页
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")
//            startActivity(intent)

            //隐式跳转 拨号
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }

    }

    //重写onMenuOpened 利用反射设置menu图标可显示
    private fun setMenuIconVisibility(menu: Menu) {
        val method = menu.javaClass.getDeclaredMethod("setOptionalIconsVisible", Boolean::class.javaPrimitiveType)
        method.isAccessible = true
        method.invoke(menu, true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        menu?.let {
            setMenuIconVisibility(menu)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> {
                toast("add_item")
            }
            R.id.remove_item -> {
                toast("remove_item")
            }
        }
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        //监听返回键
    }
}