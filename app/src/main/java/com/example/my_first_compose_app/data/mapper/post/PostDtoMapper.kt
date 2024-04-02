package com.example.my_first_compose_app.data.mapper.post

import com.example.my_first_compose_app.data.model.post.PostDto
import com.example.my_first_compose_app.domain.model.PostDomain

fun PostDto.toDomain() = PostDomain(
    id = id,
    images = images,
    title = title,
    comments = comments,
    likes = likes,
    shareContent = shareContent,
    owner = owner.toDomain()
)

private fun PostDto.OwnerDto.toDomain() = PostDomain.OwnerDomain(
    firstName = firstName,
    lastName = lastName,
    profile = profile,
    postDate = postDate
)