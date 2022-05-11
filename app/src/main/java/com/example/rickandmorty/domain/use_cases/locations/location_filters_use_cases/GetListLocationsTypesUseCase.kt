package com.example.rickandmorty.domain.use_cases.locations.location_filters_use_cases

import com.example.rickandmorty.domain.repositories.locations_repositories.GetLocationFiltersRepository
import kotlinx.coroutines.flow.Flow

class GetListLocationsTypesUseCase(
    private val getLocationFiltersRepository: GetLocationFiltersRepository
) {

    fun execute(): Flow<List<String>?> {
        return getLocationFiltersRepository.getListLocationsTypes()
    }
}