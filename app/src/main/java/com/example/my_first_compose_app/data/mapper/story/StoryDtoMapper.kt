package com.example.my_first_compose_app.data.mapper.story

import com.example.my_first_compose_app.data.model.story.StoryDto
import com.example.my_first_compose_app.domain.model.Story


fun StoryDto.toDomain(): Story {
    return Story(
        id = id,
        cover = cover,
        title = title
    )
}