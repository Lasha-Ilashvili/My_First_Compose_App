package com.example.my_first_compose_app.di

import com.example.my_first_compose_app.BuildConfig.BASE_URL
import com.example.my_first_compose_app.BuildConfig.DEBUG
import com.example.my_first_compose_app.data.common.HandleResponse
import com.example.my_first_compose_app.data.service.post.PostsService
import com.example.my_first_compose_app.data.service.story.StoriesService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()

        if (DEBUG) builder.addInterceptor(loggingInterceptor)

        return builder.build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
    }

    @Singleton
    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideHandleResponse(): HandleResponse {
        return HandleResponse()
    }

    @Singleton
    @Provides
    fun providePostsService(retrofit: Retrofit): PostsService {
        return retrofit.create(PostsService::class.java)
    }

    @Singleton
    @Provides
    fun provideStoriesService(retrofit: Retrofit): StoriesService {
        return retrofit.create(StoriesService::class.java)
    }
}