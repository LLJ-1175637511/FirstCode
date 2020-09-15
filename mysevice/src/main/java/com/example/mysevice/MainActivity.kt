package com.example.mysevice


import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private var handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                update -> {
                    tv.text = "handler"
                    msg.data.getString("msg")?.let { Log.d(TAG, it) }
                }
                progressService -> {
                    Log.d(TAG, msg.arg1.toString())
//                    Toast.makeText(this@MainActivity,msg.arg1,Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    lateinit var downloadBinder: MyService.DownloadBinder
    private var connection: ServiceConnection? = null

    private val myIntentService by lazy { MyIntentService() }

    init {
        connection = object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?) {
                connection = null
                Log.d(MyService.TAG, "unbind")
            }

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                downloadBinder = service as MyService.DownloadBinder
                downloadBinder.startDownload()
                val progress = downloadBinder.getProgress()
                val msg = Message()
                msg.what = progressService
                msg.arg1 = progress
                handler.sendMessage(msg)
            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler_bt.setOnClickListener {
            thread {
                val msg = Message()
                msg.what = update
                //Message.obj可以携带一个任意数据类型的对象
//                msg.obj = mutableListOf("")
                val bundle = Bundle()
                bundle.putString("msg", "hhh")
                msg.data = bundle
                handler.sendMessage(msg)
            }
        }

        startService_bt.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent)
        }

        stopService_bt.setOnClickListener {
            unbindMyService()
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        }

        bindService_bt.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            connection?.let { it1 -> bindService(intent, it1, Context.BIND_AUTO_CREATE) }//绑定Service
            serviceBindState = true
        }

        unbindService_bt.setOnClickListener {
            unbindMyService()
        }

        exit_bt.setOnClickListener {
            finish()
        }

        startIntentService_bt.setOnClickListener {
            val intent = Intent(this,MyIntentService::class.java)
            startService(intent)
            myIntentService.workStart(this,intent)
        }

        stopIntentService_bt.setOnClickListener {
            val intent = Intent(this,MyIntentService::class.java)
            stopService(intent)
        }
    }

    /**
     * 解绑Service
     */
    private fun unbindMyService() {
        if (serviceBindState) {
            connection?.let { it1 ->
                serviceBindState = false
                unbindService(it1)
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitProgram()
            return false
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun exitProgram() {
        val diffTime = System.currentTimeMillis() - downBackTime
        if (diffTime >= 1200) {
            downBackTime = System.currentTimeMillis()
        } else {
            //隐藏在后台 不退出程序
            moveTaskToBack(false)
//            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        const val TAG = "MyMainActivity"
        var update = 1
        var progressService = 2
        var serviceBindState = false
        var intentServiceBindState = false
        var downBackTime = 0L
    }
}
