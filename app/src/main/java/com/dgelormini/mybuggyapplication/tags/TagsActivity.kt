package com.dgelormini.mybuggyapplication.tags

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dgelormini.mybuggyapplication.R
import com.dgelormini.mybuggyapplication.tags.data.TagRepo
import com.dgelormini.mybuggyapplication.tags.data.model.Tag
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

private const val MAX_TAGS = 5

class TagsActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, TagsActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val chipGroup: ChipGroup by lazy { findViewById(R.id.tags_chip_group) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tags)

        initTags()
    }

    private fun initTags() {
        val tags: List<Tag> = TagRepo.getTags()

        tags.map { tag ->
            Chip(this).apply {
                text = Regex("[^\\w\\d_]").replace(tag.name, "-")
                setOnClickListener {
                    Toast.makeText(this@TagsActivity, "Clicked ${tag.name}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
            .take(MAX_TAGS)
            .map { chipGroup.addView(it) }
    }
}
