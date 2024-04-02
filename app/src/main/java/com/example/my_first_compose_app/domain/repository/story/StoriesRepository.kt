package com.example.my_first_compose_app.domain.repository.story

import com.example.my_first_compose_app.data.common.Resource
import com.example.my_first_compose_app.domain.model.Story
import kotlinx.coroutines.flow.Flow

interface StoriesRepository {
    suspend fun getStories(): Flow<Resource<List<Story>>>
}