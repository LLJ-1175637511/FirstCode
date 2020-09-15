package com.example.thefirstcode.activity_launchmode

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.thefirstcode.R
import kotlinx.android.synthetic.main.sec_activity.*

class SecondActivity : BaseActivity() {

    companion object {
        const val TAG = "SecondActivity"

        /***
         * 将需要带参数跳转的intent封装 利于同事方便 使用你所维护的代码
         */
        fun actionActivity(context: Context, data1: String, data2: String) {
//            val intent = Intent(context,SecondActivity::class.java)
//            intent.putExtra("params1",data1)
//            intent.putExtra("params2",data2)
//            context.startActivity(intent)
            //高阶函数简化intent构建 apply函数传入的lambda表达式 最后一行不是返回值 将调用的对象在{}构建之后返回
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra("params1", data1)
                putExtra("params2", data2)
            }
            context.startActivity(intent)
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "task is $taskId")
        setContentView(R.layout.sec_activity)

        return_bt.setOnClickListener {
//            val intent = Intent(this,ActivitySingleTop::class.java)
//            val intent = Intent(this,ActivitySingleTask::class.java)
//            Log.d(TAG,this.toString())
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        //一行代码调用 带参数的跳转
//        actionActivity(this,"data1","data2")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

}