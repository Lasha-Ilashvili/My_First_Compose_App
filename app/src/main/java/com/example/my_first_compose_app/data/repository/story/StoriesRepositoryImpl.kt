package com.example.my_first_compose_app.data.repository.story

import com.example.my_first_compose_app.data.common.HandleResponse
import com.example.my_first_compose_app.data.common.Resource
import com.example.my_first_compose_app.data.mapper.base.asResource
import com.example.my_first_compose_app.data.mapper.story.toDomain
import com.example.my_first_compose_app.data.service.story.StoriesService
import com.example.my_first_compose_app.domain.model.Story
import com.example.my_first_compose_app.domain.repository.story.StoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StoriesRepositoryImpl @Inject constructor(
    private val storiesService: StoriesService,
    private val handleResponse: HandleResponse,
) : StoriesRepository {

    override suspend fun getStories(): Flow<Resource<List<Story>>> {
        return handleResponse.safeApiCall {
            storiesService.getStories()
        }.asResource {
            it.map { dto ->
                dto.toDomain()
            }
        }
    }
}
