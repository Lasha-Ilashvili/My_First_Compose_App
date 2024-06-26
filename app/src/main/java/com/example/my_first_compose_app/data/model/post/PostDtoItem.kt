package com.example.my_first_compose_app.data.model.post


import com.squareup.moshi.Json


data class PostDto(
    val id: Int,
    val images: List<String>?,
    val title: String,
    val comments: Int,
    val likes: Int,
    @Json(name = "share_content")
    val shareContent: String,
    val owner: OwnerDto
) {
    data class OwnerDto(
        @Json(name = "first_name")
        val firstName: String,
        @Json(name = "last_name")
        val lastName: String,
        val profile: String?,
        @Json(name = "post_date")
        val postDate: Long
    )
}