package com.example.message

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat

object NotificationObj {

    private var manager: NotificationManager ?= null
    private lateinit var notification: Notification

    const val MESSAGE_ACTIVITY_ID = 1

    fun createNotification(act: Activity, title: String, content: String, miniIcon: Int,id:Int) {
        manager = act.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val resultIntent = Intent(act, MessageActivity::class.java)
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val resultPendingIntent =
            PendingIntent.getActivity(act, 5, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("id", "name", NotificationManager.IMPORTANCE_HIGH)
            manager?.createNotificationChannel(channel)
            notification = NotificationCompat.Builder(act, "id")
                .setSound(android.provider.Settings.System.DEFAULT_NOTIFICATION_URI)
                .setContentTitle(title)
                .setContentText(content)
                .setTicker("消息来了")
                .setContentIntent(resultPendingIntent)
                //让通知左右滑的时候不能取消通知
                .setAutoCancel(false)
                .setSmallIcon(miniIcon)
//                .setLargeIcon(BitmapFactory.decodeResource(act.resources, R.mipmap.author_icon))
                .setWhen(System.currentTimeMillis())
                //设置通知提示音
//            .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
                //设置振动， 需要添加权限  <uses-permission android:name="android.permission.VIBRATE"/>
//            .setVibrate(longArrayOf(0,1000,1000,1000))
                //使用默认效果， 会根据手机当前环境播放铃声， 是否振动
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
//                .setStyle(NotificationCompat.BigTextStyle().bigText("好长好长好长好长好长好长好长好长好长好长好长好长的话啊"))
                .build()
        }
        manager?.notify(id, notification)
    }

    fun cancel(id:Int){
        manager?.cancel(id)
    }
}