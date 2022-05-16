package com.example.rickandmorty.data.repositories.episodes_repositories

import androidx.paging.*
import com.example.rickandmorty.data.mapper.entity_to_domain_model.CharacterEntityToDomainModel
import com.example.rickandmorty.data.mapper.entity_to_domain_model.EpisodeEntityToDomainModel
import com.example.rickandmorty.data.paging.characters_paging.CharactersRemoteMediator
import com.example.rickandmorty.data.paging.epispdes_paging.EpisodesRemoteMediator
import com.example.rickandmorty.data.remote.api.episodes.EpisodesApi
import com.example.rickandmorty.data.storage.room.dao.EpisodeDao
import com.example.rickandmorty.data.storage.room.db.RickAndMortyDatabase
import com.example.rickandmorty.domain.models.episode.EpisodeModel
import com.example.rickandmorty.domain.repositories.episodes_repositories.EpisodesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class EpisodesRepositoryImpl(
    private val episodesApi: EpisodesApi,
    private val db: RickAndMortyDatabase
): EpisodesRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getAllEpisodes(): Flow<PagingData<EpisodeModel>> {
        val pagingSourceFactory = { db.getEpisodeDao().getAllEpisodes() }

        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = EpisodesRemoteMediator(
                episodesApi = episodesApi,
                db = db
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow.map { pagingData ->
            pagingData.map { it ->
                EpisodeEntityToDomainModel().transform(it)
            }
        }
    }

    override fun getAllEpisodesByFilters(name: String?, episode: String?): List<EpisodeModel> {
        TODO("Not yet implemented")
    }

    override fun getAllEpisodesByIds(ids: List<Int>): List<EpisodeModel> {
        TODO("Not yet implemented")
    }

}