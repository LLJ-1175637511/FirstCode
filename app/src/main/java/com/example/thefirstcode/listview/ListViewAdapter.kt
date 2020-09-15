package com.example.thefirstcode.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.thefirstcode.R

class ListViewAdapter(context: Context, val layoutId: Int, data: List<FruitBean>) :
    ArrayAdapter<FruitBean>(context, layoutId, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder:ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(layoutId, parent, false)
            val img = view.findViewById<ImageView>(R.id.imgId)
            val tv = view.findViewById<TextView>(R.id.nameId)
            viewHolder = ViewHolder(img,tv)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item = getItem(position)
        item?.let {
            viewHolder.iv.setImageResource(it.imgId)
            viewHolder.tv.text = it.name
        }

        return view
    }

    inner class ViewHolder(val iv:ImageView,val tv:TextView)
}