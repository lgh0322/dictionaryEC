package com.vaca.dic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.InputStream





class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dictionaryStream: InputStream = assets.open("Di.fu")
        val size: Int = dictionaryStream.available()
        val dicByteArray = ByteArray(size)
        dictionaryStream.read(dicByteArray)
        Log.e("fuck","的实力开发就$size")
    }
}