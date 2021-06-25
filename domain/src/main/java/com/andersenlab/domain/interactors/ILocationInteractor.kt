package com.andersenlab.domain.interactors

import com.andersenlab.domain.entities.Location
import com.andersenlab.domain.entities.Locations
import com.andersenlab.domain.entities.LocationsFilter
import com.andersenlab.domain.repository.IRepository
import javax.inject.Inject

interface ILocationInteractor {

    suspend fun getAllLocations(page: Int, filter: LocationsFilter): Locations

    suspend fun getLocationById(id: Int): Location

    suspend fun getLocationsById(id: String): List<Location>
}

class LocationInteractor @Inject constructor(private val repository: IRepository) :
    ILocationInteractor {

    override suspend fun getAllLocations(page: Int, filter: LocationsFilter) = repository.getAllLocations(page, filter)

    override suspend fun getLocationById(id: Int) = repository.getLocationById(id)

    override suspend fun getLocationsById(id: String) = repository.getLocationsById(id)

}