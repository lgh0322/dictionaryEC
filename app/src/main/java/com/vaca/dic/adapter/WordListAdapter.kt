package com.vaca.dic.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.vaca.dic.R
import com.vaca.dic.bean.SearchResult
import com.vaca.dic.view.CustomSwipeLayout

import java.util.*

class WordListAdapter(
    val context: Context,
) :
    RecyclerView.Adapter<WordListAdapter.ViewHolder>() {
    var mEcgData: MutableList<SearchResult> = ArrayList()
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    var currentSelect: Int = 0


    interface ClickEcg {
        fun givePosition(position: Int)
        fun clear()
    }

    var clickEcg: ClickEcg? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_word, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (currentSelect == position) {

        } else {

        }

        mEcgData[position].run {


        }
    }


    private fun secondToTime(second: Long): String? {
        var sec = second
        sec %= 86400
        val hours = sec / 3600
        sec %= 3600
        val minutes = sec / 60
        sec %= 60
        if (hours.toInt() == 0) {
            return String.format(
                "%02d",
                minutes
            ) + ":" + String.format("%02d", sec)
        }
        return String.format("%02d", hours) + ":" + String.format(
            "%02d",
            minutes
        ) + ":" + String.format("%02d", sec)
    }


    fun setList(userBean: List<SearchResult>) {
        mEcgData.clear()
        mEcgData = userBean as MutableList<SearchResult>
        notifyDataSetChanged()
    }

    private fun timeConvert(s: String): String {
        var t: String = s.substring(1, 5)
        t += "-"
        t += s.substring(5, 7)
        t += "-"
        t += s.substring(7, 9)
        t += " "
        t += s.substring(9, 11)
        t += ":"
        t += s.substring(11, 13)
        t += ":"
        t += s.subSequence(13, 15)
        return t
    }


    override fun getItemCount(): Int {
        return mEcgData.size
    }

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val timeStart: TextView = itemView.findViewById(R.id.timeStart)
        val moT: TextView = itemView.findViewById(R.id.monitorTime)
        val x1: ImageView = itemView.findViewById(R.id.x1)
        val result: TextView = itemView.findViewById(R.id.result)
        val del = itemView.findViewById<TextView>(R.id.be_bp_list_delete)

        val mainItem: LinearLayout = itemView.findViewById(R.id.gaga)
        val kk: CustomSwipeLayout = itemView.findViewById(R.id.bp_swipe)

        init {

            del.setOnClickListener {

            }


            mainItem.setOnClickListener {


                clickEcg?.givePosition(layoutPosition)
                notifyDataSetChanged()
            }


        }
    }


}