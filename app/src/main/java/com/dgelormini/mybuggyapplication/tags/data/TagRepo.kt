package com.dgelormini.mybuggyapplication.tags.data

import com.dgelormini.mybuggyapplication.tags.data.model.Tag

object TagRepo {

    fun getTags(): List<Tag> {
        return (1..200).map {
            Tag("Tag:#$it")
        }
    }
}
