package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * 静态注册广播
 * 1、在AndroidManifest文件中使用<receive> ... <receive/> 标签
 * 2、编译器快捷方式 New->Other->Broadcast Receiver
 *    选项 Exported:是否允许这个BroadcastReceiver接收本程序以外的广播
 *    选项 Enable:是否启用这个BroadcastReceiver
 */
class BootCompleteReceiver : BroadcastReceiver() {

    /**
     * 想要使用开机的状态信息 还要在AndroidManifest文件中声明使用权限
     * <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>
     */
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "开机", Toast.LENGTH_LONG).show()
    }
}
