package com.vaca.dic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.InputStream
import java.nio.charset.StandardCharsets.UTF_16LE


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dictionaryStream: InputStream = assets.open("Di.fu")
        val size: Int = dictionaryStream.available()
        val dicByteArray = ByteArray(size)
        dictionaryStream.read(dicByteArray)

        var fuck=dicByteArray.copyOfRange(200,222)
        val x=String(byteArrayOf(78.toByte(),103.toByte()),UTF_16LE)
        Log.e("fuck","$x")
        sea(x)


       

    }


    fun sea(st:String):Int{
        val s=st.toLowerCase()
        if(s=="z"){
            return -1
        }
        val di=s.toByteArray(UTF_16LE)
        for(k in di){
            Log.e("fuckfuck",k.toUByte().toInt().toString())
        }
        return 0

    }



}