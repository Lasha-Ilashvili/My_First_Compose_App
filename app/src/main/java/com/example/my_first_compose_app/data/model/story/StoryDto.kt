package com.example.my_first_compose_app.data.model.story


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StoryDto(
    val id: Int,
    val cover: String,
    val title: String
)