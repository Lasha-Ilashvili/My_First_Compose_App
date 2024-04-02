package com.example.my_first_compose_app.domain.usecase

import com.example.my_first_compose_app.domain.repository.story.StoriesRepository
import javax.inject.Inject

class GetStoriesUseCase @Inject constructor(
    private val storiesRepository: StoriesRepository
) {
    suspend operator fun invoke() =
        storiesRepository.getStories()
}