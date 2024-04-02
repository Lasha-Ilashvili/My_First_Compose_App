package com.example.my_first_compose_app.domain.repository.post

import com.example.my_first_compose_app.data.common.Resource
import com.example.my_first_compose_app.domain.model.PostDomain
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    suspend fun getPosts(): Flow<Resource<List<PostDomain>>>

    suspend fun getPostDetails(id: Int): Flow<Resource<PostDomain>>
}