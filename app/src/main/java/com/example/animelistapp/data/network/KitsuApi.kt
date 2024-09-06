package com.example.animelistapp.data.network

import com.example.animelistapp.data.network.dto.AnimeResponseDto
import com.example.animelistapp.data.network.dto.TrendingAnimeListDto
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface KitsuApi {

    @GET("trending/anime")
    fun getTrendingAnimeList(): ApiResponse<TrendingAnimeListDto>

    @GET("anime/{id}")
    fun getAnimeById(@Path("id") id: Int): ApiResponse<AnimeResponseDto?>

    companion object {
        const val BASE_URL = "https://kitsu.io/api/edge/"
    }
}