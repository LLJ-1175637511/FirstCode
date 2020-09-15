package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ResultReceiver
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 广播机制：
 * 1、动态注册广播
 *    注意：动态添加的广播在不使用时要 unregisterReceiver(广播)注销掉
 *    缺点：动态的广播只有在activity创建或活跃时 才可以使用 不能在程序未启动时获取系统的信息
 *    可以注册的广播在 SDK\platforms\android-版本\data\broadcast_actions.txt中可以查看
 * 2、onReceive()方法中尽量使用较少的逻辑或者耗时操作 这个方法调用长时间未结束 程序就会崩溃
 * 3、onReceive()中不允许开启线程
 */
class MainActivity : AppCompatActivity() {

    lateinit var timeChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //2、标准广播
//            val intent =Intent("com.example.broadcast.MY_BROADCAST")
//            intent.setPackage(packageName)
//            sendBroadcast(intent)
            //3、有序广播
            val intent = Intent("com.example.broadcast.MY_BROADCAST")
            sendOrderedBroadcast(intent,null)
        }
        //1、动态添加系统广播
//        val intentFilter = IntentFilter()
//        intentFilter.addAction("android.intent.action.TIME_TICK")
//        timeChangeReceiver = TimeChangeReceiver()
//        registerReceiver(timeChangeReceiver,intentFilter)
    }

    inner class TimeChangeReceiver:BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            Toast.makeText(p0, "time change", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }
}
