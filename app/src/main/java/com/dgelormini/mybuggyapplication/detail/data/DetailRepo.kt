package com.dgelormini.mybuggyapplication.detail.data

import com.dgelormini.mybuggyapplication.detail.DetailItem

object DetailRepo {

    fun getItems(): List<DetailItem> {
        return listOf(
                DetailItem("Image 1", "img_1.png"),
                DetailItem("Image 2", "img_2.png"),
                DetailItem("Image 3", "img_3.png"),
                DetailItem("Image 4", "img_4.png"),
                DetailItem("Image 5", "img_5.png")
        )
    }
}
