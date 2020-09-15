package com.example.thefirstcode.mychat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thefirstcode.R
import com.example.thefirstcode.toast
import kotlinx.android.synthetic.main.mychat_activity.*

class ChatActivity : AppCompatActivity() {

    private val msgList = mutableListOf<MsgBean>()

    private val adapter by lazy { ChatAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mychat_activity)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        send_msg.setOnClickListener {
            val inputText = input_msg.text.trim().toString()
            if (inputText == "") toast("输入信息不能为空")
            else {
                updateMsgData(inputText)
                input_msg.setText("")
            }
        }
    }

    private fun updateMsgData(msg:String) {
        msgList.add(MsgBean(msg,MsgBean.TYPE_SEND))
        adapter.updateData(msgList)
        recyclerView.scrollToPosition(msgList.size-1)

        msgList.add(MsgBean(msg,MsgBean.TYPE_RECEIVED))
        adapter.updateData(msgList)
        recyclerView.scrollToPosition(msgList.size-1)

    }


}