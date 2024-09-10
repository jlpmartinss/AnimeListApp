package com.example.animelistapp.data.repository

import com.example.animelistapp.data.network.KitsuApi
import com.example.animelistapp.domain.model.AnimeData
import com.example.animelistapp.domain.repository.KitsuRepository
import com.skydoves.sandwich.onSuccess
import javax.inject.Inject

class KitsuRepositoryImpl @Inject constructor(
    private val api: KitsuApi
) : KitsuRepository {

    override suspend fun getTrendingAnimeList(): List<AnimeData> {
        var animeData: List<AnimeData> = emptyList()
        api.getTrendingAnimeList()
            .onSuccess {
                animeData = data.data.map { it.toModel() }
            }

        return animeData
    }

    override suspend fun getAnimeById(id: Int): AnimeData? {
        var anime: AnimeData? = null

        api.getAnimeById(id)
            .onSuccess {
                anime = data?.data?.toModel()
            }
        return anime
    }

}