package com.example.broadcastreceiver.example

import android.content.*
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity:AppCompatActivity() {

    lateinit var offline:ForceOfflineReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.broadcast.Force_OFFLINE")
        offline = ForceOfflineReceiver()
        registerReceiver(offline,intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(offline)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    inner class ForceOfflineReceiver:BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            if (p0==null) return
            AlertDialog.Builder(p0).apply {
                setTitle("Worn")
                setMessage("登录状态异常 系统强制下线")
                //设置为不可取消（否则点击取消 就会取消弹窗）
                setCancelable(false)
                setPositiveButton("我知道了"){ _: DialogInterface, _: Int ->
                    ActivityCollector.clearAllActivity()
                    val intent = Intent(this@BaseActivity,LoginActivity::class.java)
                    startActivity(intent)
                }
                show()
            }
        }

    }
}