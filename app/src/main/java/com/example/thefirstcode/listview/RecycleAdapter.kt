package com.example.thefirstcode.listview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thefirstcode.R
import com.example.thefirstcode.toast

class RecycleAdapter(val fruitList:List<FruitBean>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.imgId)
        val name = view.findViewById<TextView>(R.id.nameId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false)
        val viewHolder = ViewHolder(view)
        viewHolder.run {
            itemView.setOnClickListener {
                parent.context.toast("item")
            }
            img.setOnClickListener {
                parent.context.toast("img")
            }
        }
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = fruitList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = fruitList[position]
        val mHolder = holder as ViewHolder
        mHolder.img.setImageResource(data.imgId)
        mHolder.name.text = data.name
    }

}