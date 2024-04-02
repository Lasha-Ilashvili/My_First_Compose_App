package com.example.my_first_compose_app.data.repository.post

import com.example.my_first_compose_app.data.common.HandleResponse
import com.example.my_first_compose_app.data.common.Resource
import com.example.my_first_compose_app.data.mapper.base.asResource
import com.example.my_first_compose_app.data.mapper.post.toDomain
import com.example.my_first_compose_app.data.service.post.PostsService
import com.example.my_first_compose_app.domain.model.PostDomain
import com.example.my_first_compose_app.domain.repository.post.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val postsService: PostsService,
    private val handleResponse: HandleResponse,
) : PostsRepository {

    override suspend fun getPosts(): Flow<Resource<List<PostDomain>>> {
        return handleResponse.safeApiCall {
            postsService.getPosts()
        }.asResource {
            it.map { dto ->
                dto.toDomain()
            }
        }
    }

    override suspend fun getPostDetails(id: Int): Flow<Resource<PostDomain>> {
        return handleResponse.safeApiCall {
            postsService.getPostDetails(id)
        }.asResource { dto ->
            dto.toDomain()
        }
    }
}
