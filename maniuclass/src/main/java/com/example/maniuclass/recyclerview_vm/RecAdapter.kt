package com.example.maniuclass.recyclerview_vm

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.maniuclass.BR
import com.example.maniuclass.R
import com.example.maniuclass.databinding.ItemRecBinding

class RecAdapter :
    RecyclerView.Adapter<RecAdapter.RecViewHolder>() {

    private val list = mutableListOf<ItemBean>()

    inner class RecViewHolder(private var itemDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(itemDataBinding.root) {

        fun getDataBinding(): ViewDataBinding {
            return this.itemDataBinding
        }

        fun setDataBinding(itemDataBinding: ViewDataBinding){
            this.itemDataBinding = itemDataBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val recDataBinding = DataBindingUtil.inflate<ItemRecBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_rec,
            parent,
            false
        )
        return RecViewHolder(recDataBinding)
    }

    override fun getItemCount(): Int = this.list.size

    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {
        holder.getDataBinding().setVariable(BR.itemUser,list[position])
    }

    fun loadData(list: MutableList<ItemBean>?) {
        if (!list.isNullOrEmpty()) {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
        Log.d(TAG,"list:${list?.size} recList:${this.list.size}")
    }

    fun loadOneData(item:ItemBean) {
        this.list.add(item)
        notifyItemInserted(list.size+1)
        Log.d(TAG,"list:${list.size} recList:${this.list.size}")
    }

    companion object{
        const val TAG = "RecAdapter"
    }
}