package com.example.animelistapp.data.di

import com.example.animelistapp.data.network.KitsuApi
import com.example.animelistapp.data.repository.KitsuRepositoryImpl
import com.example.animelistapp.domain.repository.KitsuRepository
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    @Provides
    @Singleton
    fun provideKitsuApi(moshi: Moshi): KitsuApi =
        Retrofit.Builder()
            .baseUrl(KitsuApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
            .create(KitsuApi::class.java)


    @Provides
    @Singleton
    fun provideKitsuRepository(api: KitsuApi): KitsuRepository =
        KitsuRepositoryImpl(api)

}