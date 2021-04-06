package com.dgelormini.mybuggyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dgelormini.mybuggyapplication.detail.DetailActivity
import com.dgelormini.mybuggyapplication.tags.TagsActivity
import kotlin.LazyThreadSafetyMode.*

class MainActivity : AppCompatActivity() {
    private val tagsButton: View by lazy(NONE) { findViewById(R.id.tags_button) }
    private val listButton: View by lazy(NONE) { findViewById(R.id.list_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tagsButton.setOnClickListener {
            TagsActivity.start(this)
        }

        listButton.setOnClickListener {
            DetailActivity.start(this)
        }
    }
}
