package com.example.socialfeed_hw22.di

import com.example.my_first_compose_app.data.common.HandleResponse
import com.example.my_first_compose_app.data.repository.post.PostsRepositoryImpl
import com.example.my_first_compose_app.data.repository.story.StoriesRepositoryImpl
import com.example.my_first_compose_app.data.service.post.PostsService
import com.example.my_first_compose_app.data.service.story.StoriesService
import com.example.my_first_compose_app.domain.repository.post.PostsRepository
import com.example.my_first_compose_app.domain.repository.story.StoriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePostsRepository(
        postsService: PostsService,
        handleResponse: HandleResponse
    ): PostsRepository {
        return PostsRepositoryImpl(
            postsService = postsService,
            handleResponse = handleResponse
        )
    }

    @Singleton
    @Provides
    fun provideStoriesRepository(
        storiesService: StoriesService,
        handleResponse: HandleResponse
    ): StoriesRepository {
        return StoriesRepositoryImpl(
            storiesService = storiesService,
            handleResponse = handleResponse
        )
    }
}