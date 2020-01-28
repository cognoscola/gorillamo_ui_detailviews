package com.gorillamo.ui.detailview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * An adapter which will hold maxNumber of items
 * @param items the string items to pick from
 * @param itemClickedCallback is the call back when the item is selected
 */
internal class DetailListAdapter(
    private val items:Array<String>,
    private val itemClickedCallback:((View)->Any?)? = null): RecyclerView.Adapter<DetailListAdapter.TimeItem>(){


    override fun onBindViewHolder(holder: TimeItem, position: Int) {

        holder.text.text = items[position]
        holder.layout.setOnClickListener {

            itemClickedCallback?.invoke(it)
        }

        /** for this button we'll animate alpha randomly **/
        holder.layout.startAnimation(AlphaAnimation(0.0f,1.0f).apply {
            duration = 500
            startOffset = (position * 100).toLong()
        })

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeItem {

        val inflater = LayoutInflater.from(parent.context)
        return TimeItem(inflater.inflate(R.layout.item_detail,parent,false))
    }


    class TimeItem(view:View): RecyclerView.ViewHolder(view){

        var layout: View =view.findViewById(R.id.item_layout)
        var text: TextView = view.findViewById(R.id.itemTextView)
    }

}