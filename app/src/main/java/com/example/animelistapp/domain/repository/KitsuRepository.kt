package com.example.animelistapp.domain.repository

import com.example.animelistapp.domain.model.AnimeData

interface KitsuRepository {

    fun getTrendingAnimeList(): List<AnimeData>

    fun getAnimeById(id: Int): AnimeData?
}