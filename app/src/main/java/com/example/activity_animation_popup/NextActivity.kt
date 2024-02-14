package com.example.activity_animation_popup

import ItemClickListener
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.activity_animation_popup.adapter.S_Adapter

import com.example.activity_animation_popup.model.Studentlist_model


class NextActivity : AppCompatActivity() {
    lateinit var mContext: Context
    lateinit var title: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var studentlist: Array<String>
    lateinit var list: ArrayList<Studentlist_model>
    lateinit var itemClickListener: ItemClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        mContext = this
        title = findViewById(R.id.title)
        val animSlideup = AnimationUtils.loadAnimation(this, R.anim.slide_in_up)
        list = ArrayList()

        var model=Studentlist_model("aparna",false)
        list.add(model)
        var xmodel=Studentlist_model("Indu",false)
        list.add(xmodel)
        var nmodel=Studentlist_model("Sajna",false)
        list.add(nmodel)

        studentlist = getResources().getStringArray(R.array.student_list)
        Log.e("arr", list.size.toString())

        recyclerView = findViewById(R.id.rec_view)
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        val adptr = S_Adapter(list)
        recyclerView.adapter = adptr


        title.setOnClickListener() {
            recyclerView.startAnimation(animSlideup)
            recyclerView.setVisibility(View.VISIBLE)
        }
    }
}
