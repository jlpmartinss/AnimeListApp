package com.example.animelistapp.domain.repository

import com.example.animelistapp.domain.model.AnimeData

interface KitsuRepository {

    suspend fun getTrendingAnimeList(): List<AnimeData>

    suspend fun getAnimeById(id: Int): AnimeData?
}