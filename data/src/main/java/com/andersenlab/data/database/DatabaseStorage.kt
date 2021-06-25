package com.andersenlab.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andersenlab.data.database.dao.RickAndMortyDao
import com.andersenlab.domain.entities.CharacterEntity
import com.andersenlab.domain.entities.EpisodeEntity
import com.andersenlab.domain.entities.LocationEntity

@Database(
    entities = [CharacterEntity::class, LocationEntity::class, EpisodeEntity::class],
    version = 1
)
abstract class DatabaseStorage : RoomDatabase() {

    abstract val rickAndMortyDao: RickAndMortyDao

    companion object {
        const val RICK_AND_MORTY_DATA_BASE = "RICK_AND_MORTY_DATA_BASE"
    }

}