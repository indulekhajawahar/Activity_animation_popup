package com.example.activity_animation_popup.adapter

import ItemClickListener
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.activity_animation_popup.R
import com.example.activity_animation_popup.model.Studentlist_model


class S_Adapter (var list: ArrayList<Studentlist_model>) :
    RecyclerView.Adapter<S_Adapter.ViewHolder>() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.next_adapter, viewGroup, false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceType")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val n = viewHolder.title.setText(list[position].name)
        viewHolder.button.setOnClickListener() {

            var foundPosition = -1
            var isFound: Boolean = false

            for (i in 0..list.size-1)
            {
                if (list.get(i).isclicked)
                {
                    foundPosition=i
                    isFound=true
                }
            }

            if (isFound)
            {
                if (position==foundPosition)
                {
                    // make it as false
                    list.get(foundPosition).isclicked=false
                    notifyDataSetChanged()
                }
                else
                {
                    list.get(foundPosition).isclicked=false
                    list.get(position).isclicked=true
                    notifyDataSetChanged()
                }
            }
            else
            {
                list.get(position).isclicked=true
                notifyDataSetChanged()
            }
        }

        if (list.get(position).isclicked)
        {
            viewHolder.button.setBackgroundResource(R.drawable.circle_fill)
        }
        else
        {
            viewHolder.button.setBackgroundResource(R.drawable.circle_shape)
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView
        var button: Button



        init {
            title = itemView.findViewById(R.id.list)
            button = itemView.findViewById(R.id.btn)


        }

    }
}