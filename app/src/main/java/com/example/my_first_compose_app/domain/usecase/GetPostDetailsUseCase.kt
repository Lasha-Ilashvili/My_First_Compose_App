package com.example.my_first_compose_app.domain.usecase

import com.example.my_first_compose_app.domain.repository.post.PostsRepository
import javax.inject.Inject

class GetPostDetailsUseCase @Inject constructor(
    private val postsRepository: PostsRepository
) {
    suspend operator fun invoke(id: Int) =
        postsRepository.getPostDetails(id)
}