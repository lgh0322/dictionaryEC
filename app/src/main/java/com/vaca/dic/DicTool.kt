package com.vaca.dic

import android.content.Context
import com.vaca.dic.bean.SearchResult
import java.io.InputStream
import java.nio.charset.StandardCharsets

object DicTool {




    lateinit var dicByteArray: ByteArray
    lateinit var inputWord: ByteArray



    fun dicToolInit(context: Context){
        context.run {
            val dictionaryStream: InputStream = assets.open("Di.fu")
            val size: Int = dictionaryStream.available()
            dicByteArray = ByteArray(size)
            dictionaryStream.read(dicByteArray)
        }
    }


    enum class JudgeSet{
        MeetSmaller,MeetGreater,MeetPrefix,MeetEqual
    }


    enum class StillState{
        NotStill,StillLow,StillHigh
    }


    fun getExplain(index:Int):SearchResult{
        if(index==-1){
            return SearchResult("","")
        }
        val head=index+1
        val explainHead= findBody(head)
        val tail= findTail(head)
        val headString=String(dicByteArray.copyOfRange(head*2,explainHead*2),StandardCharsets.UTF_16LE)
        val body= String(dicByteArray.copyOfRange(explainHead*2,tail*2),StandardCharsets.UTF_16LE)
        return SearchResult(headString,body)
    }






    //---------------------------------------------二分法寻找位置的
    fun searchString2Index(st: String): Int {
        val s = st.toLowerCase()  //---------------------先转化成小写
        if (s == "z") {
            return -1
        }
        if(s.isEmpty()){
            return -1
        }

        val di = transfer16(s.toByteArray(StandardCharsets.UTF_16LE))

        inputWord = di

        //判断是否是第一个

        if ((di[0] == 97.toByte()) && (di.size == 1)) {
            return 0
        }

        //判断是否是最后一个

        var tempIndex = 2600050
        tempIndex = findHead(tempIndex)
//--------------------------------------------------------------加1其实是加2， 跳过00头
        if (compareDicEqual(2 * (tempIndex + 1))) {
            return tempIndex
        }

//--------------------------------------------------二分法的两把刀
        var imax = tempIndex
        var imin = 0
        var currentEye=0

        var stillFlag:StillState=StillState.NotStill
        //---------------------------------------开始进行二分法操作
        do {
            currentEye = (imax + imin) / 2
            val currentHead=findHead(currentEye)

            when(compareDicAttr(2*(currentHead+1))){
                JudgeSet.MeetEqual->{
                    return currentHead
                }

                JudgeSet.MeetSmaller->{
                   if(imin==currentHead){
                       stillFlag=StillState.StillLow
                    }
                    imin=currentHead
                }

                JudgeSet.MeetGreater->{
                    if(imax==currentHead){
                        stillFlag=StillState.StillHigh
                    }
                    imax=currentHead
                }

                JudgeSet.MeetPrefix->{
                    if(imax==currentHead){
                        stillFlag=StillState.StillHigh
                    }
                    imax=currentHead
                }
            }


            when(stillFlag){
                StillState.StillLow->{
                    imin= findTail(imin+1)
                }
                StillState.StillHigh->{
                    imax=findHead(imax-1)
                }
            }

            stillFlag=StillState.NotStill

        } while (imax!=imin)


        return imax

    }

    //---------------------------------------------找到每个词前面的0， 0头的index/2
    private fun findHead(dicIndex: Int): Int {
        var currentEye = dicIndex
        var firstByte = 0
        var secondByte = 0
        do {
            currentEye--
            firstByte = dicByteArray[currentEye * 2].toUByte().toInt()
            secondByte = dicByteArray[currentEye * 2 + 1].toUByte().toInt()
        } while (!((firstByte == 0) && (secondByte == 0)))
        return currentEye
    }

    //-----------------------------------------------找到单词的尾巴
    private fun findTail(dicIndex: Int): Int {
        var currentEye = dicIndex
        var firstByte = 0
        var secondByte = 0
        do {
            currentEye++
            firstByte = dicByteArray[currentEye * 2].toUByte().toInt()
            secondByte = dicByteArray[currentEye * 2 + 1].toUByte().toInt()
        } while (!((firstByte == 0) && (secondByte == 0)))
        return currentEye
    }

    //-----------------------------------------------找到单词的中部
    private fun findBody(dicIndex: Int): Int {
        var currentEye = dicIndex
        var firstByte = 0
        var secondByte = 0
        do {
            currentEye++
            firstByte = dicByteArray[currentEye * 2].toUByte().toInt()
            secondByte = dicByteArray[currentEye * 2 + 1].toUByte().toInt()
        } while (!((firstByte == 9) && (secondByte == 0)))
        return currentEye
    }


    //----------------------------------------------比较输入的单词与词典中指定的位置是否相等
    private fun compareDicEqual(dicIndex: Int): Boolean {
        for ((wordIndex, wordContent) in inputWord.withIndex()) {
            if (dicByteArray[dicIndex + wordIndex*2] != wordContent) {
                return false
            }
        }
        return true
    }

    private fun compareDicAttr(dicIndex: Int):JudgeSet{
        for ((wordIndex, wordContent) in inputWord.withIndex()) {
            val dicInt=dicByteArray[dicIndex + wordIndex*2].toUByte().toInt()
            val wordInt=wordContent.toUByte().toInt()
            if (dicInt<wordInt) {
                return JudgeSet.MeetSmaller
            }else if(dicInt>wordInt){
                return JudgeSet.MeetGreater
            }
        }
        val firstByte = dicByteArray[dicIndex + inputWord.size*2].toUByte().toInt()
        val secondByte = dicByteArray[dicIndex + inputWord.size*2+1].toUByte().toInt()
        return if((firstByte==9)&&(secondByte==0)){
            JudgeSet.MeetEqual
        }else{
            JudgeSet.MeetPrefix
        }
    }


    private fun transfer16(b: ByteArray): ByteArray {
        return ByteArray(b.size / 2) {
            b[it * 2]
        }
    }
}