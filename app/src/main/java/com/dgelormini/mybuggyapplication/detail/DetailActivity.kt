package com.dgelormini.mybuggyapplication.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dgelormini.mybuggyapplication.R
import com.dgelormini.mybuggyapplication.detail.data.DetailRepo

class DetailActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initViews()
    }

    private fun initViews() {
        initList()
    }

    private fun initList() {
        val listItems = DetailRepo.getItems()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DetailListAdapter(listItems)
    }
}
