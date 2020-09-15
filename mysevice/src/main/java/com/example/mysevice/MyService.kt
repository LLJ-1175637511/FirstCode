package com.example.mysevice

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread

class MyService : Service() {

    private val mBinder = DownloadBinder()

    override fun onCreate() {
        super.onCreate()
        //创建一个前台服务 防止后台服务被系统回收
        //安卓9.0开始 使用前台服务需要声明权限FOREGROUND_SERVICE
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel = NotificationChannel("my_service","前台Service通知",NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        val intent = Intent(this,MainActivity::class.java)
        val pi = PendingIntent.getActivity(this,0,intent,0)
        val notification = NotificationCompat.Builder(this,"my_service")
            .setContentTitle("Service Title")
            .setContentText("Service Content")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pi)
            .build()
        startForeground(1,notification)
        Log.d(TAG,"onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        thread {
            //1、千万不要忘了执行结束后 使用stopSelf() 停止service 否则service是不会自动停止的
            //2、除了一些持久性的后台服务除外 播放音乐  持续定位等
            //3、单单执行一次任务的service更推荐jobService 或可以执行完毕 自动结束的jobIntentService
            //4、jobIntentService：要在<service/>中声明权限android:permission="android.permission.BIND_JOB_SERVICE"
            // <service android:name=".MyIntentService"
            //            android:permission="android.permission.BIND_JOB_SERVICE"
            //            android:enabled="true"
            //            android:exported="true"/>
            stopSelf()
        }
        //由于service运行于主线程
        Log.d(TAG,"onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.d(TAG,"onBind")
        return mBinder
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy")
        super.onDestroy()
    }

    class DownloadBinder:Binder(){
        fun startDownload(){
            Log.d(TAG,"DownloadBinder")
        }

        fun getProgress():Int{
            Log.d(TAG,"getProgress")
            return 0
        }
    }

    companion object{
        const val TAG = "MyService"
    }
}
