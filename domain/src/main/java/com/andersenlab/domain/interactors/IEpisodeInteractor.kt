package com.andersenlab.domain.interactors

import com.andersenlab.domain.entities.Episode
import com.andersenlab.domain.entities.Episodes
import com.andersenlab.domain.entities.EpisodesFilter
import com.andersenlab.domain.repository.IRepository
import javax.inject.Inject

interface IEpisodeInteractor {

    suspend fun getAllEpisodes(page: Int, filter: EpisodesFilter): Episodes

    suspend fun getEpisodeById(id: Int): Episode

    suspend fun getEpisodesById(id: String): List<Episode>

}

class EpisodeInteractor @Inject constructor(private val repository: IRepository) : IEpisodeInteractor {

    override suspend fun getAllEpisodes(page: Int, filter: EpisodesFilter) = repository.getAllEpisodes(page, filter)

    override suspend fun getEpisodeById(id: Int): Episode = repository.getEpisodeById(id)

    override suspend fun getEpisodesById(id: String): List<Episode> = repository.getEpisodesById(id)

}