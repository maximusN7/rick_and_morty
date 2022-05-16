package com.example.rickandmorty.domain.use_cases.locations.location_filters_use_cases

import com.example.rickandmorty.domain.repositories.locations_repositories.GetLocationFiltersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetListLocationsTypesUseCase(
    private val getLocationFiltersRepository: GetLocationFiltersRepository
) {

    fun execute(): Flow<List<String>> =
        getLocationFiltersRepository.getListLocationsTypes().map { it.distinct() }
}