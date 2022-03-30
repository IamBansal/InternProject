package com.example.internproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.internproject.adapter.ItemAdapter
import com.example.internproject.model.Item
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var itemAdapter: ItemAdapter
    lateinit var itemList : ArrayList<Item>
    lateinit var refresh : SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refresh = findViewById(R.id.refresh)
        recyclerView = findViewById(R.id.rvList)
        itemList = ArrayList()
        itemAdapter = ItemAdapter(this, itemList)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemAdapter

        var count = 0

        refresh.setOnRefreshListener {
            count++
            itemList.clear()
            for (i in 1..count) {
                itemList.add(Item(i))
            }
            Handler().postDelayed(Runnable {
                refresh.isRefreshing = false
                itemAdapter.notifyDataSetChanged()
            }, 1200)

        }

    }
}