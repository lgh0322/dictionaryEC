package com.vaca.dic

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.tencent.bugly.crashreport.CrashReport
import java.io.InputStream
import java.nio.charset.StandardCharsets.UTF_16LE


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //--------------------------------------------------------读取文本， 这个是小的在前面的
        DicTool.dicToolInit(this)


        val x=DicTool.searchString2Index("apple")
        val y=DicTool.getExplain(x)
        Log.e("fuck", y)



    }






}