package com.example.animelistapp.data.repository

import com.example.animelistapp.data.network.KitsuApi
import com.example.animelistapp.domain.model.AnimeData
import com.example.animelistapp.domain.repository.KitsuRepository
import com.skydoves.sandwich.onSuccess

class KitsuRepositoryImpl(val api: KitsuApi) : KitsuRepository {

    override fun getTrendingAnimeList(): List<AnimeData> {
        var animeList : List<AnimeData> = emptyList()
        api.getTrendingAnimeList()
            .onSuccess {
                animeList = data.data.map { it.toModel() }
            }

        return animeList
    }

    override fun getAnimeById(id: Int): AnimeData? {
        var anime : AnimeData? = null

        api.getAnimeById(id)
            .onSuccess {
                anime = data?.data?.toModel()
            }
        return anime
    }

}