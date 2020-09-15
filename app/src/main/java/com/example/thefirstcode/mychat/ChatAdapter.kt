package com.example.thefirstcode.mychat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thefirstcode.R

class ChatAdapter: RecyclerView.Adapter<MsgViewHolder>() {

    private val msgList = mutableListOf<MsgBean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MsgViewHolder =
        if (viewType == MsgBean.TYPE_RECEIVED) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item,parent,false)
            LeftViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item,parent,false)
            RightViewHolder(view)
        }

    override fun getItemCount(): Int = msgList.size

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when(holder){
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
        }
    }

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    fun updateData(list:List<MsgBean>){
        msgList.clear()
        msgList.addAll(list)
        notifyItemInserted(msgList.size-1)
    }
}