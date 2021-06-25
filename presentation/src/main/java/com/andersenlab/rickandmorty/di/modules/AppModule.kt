package com.andersenlab.rickandmorty.di.modules

import android.content.Context
import androidx.room.Room
import com.andersenlab.data.database.DatabaseStorage
import com.andersenlab.data.repository.Repository
import com.andersenlab.domain.interactors.*
import com.andersenlab.domain.repository.IRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppModule.InnerAppModule::class])
class AppModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun provideDatabaseStorage() =
        Room.databaseBuilder(
            context,
            DatabaseStorage::class.java,
            DatabaseStorage.RICK_AND_MORTY_DATA_BASE
        ).build()

    @Module
    interface InnerAppModule {

        @Binds
        @Singleton
        fun provideRepository(repository: Repository): IRepository

        @Singleton
        @Binds
        fun provideCharacterInteractor(characterInteractor: CharacterInteractor): ICharacterInteractor

        @Singleton
        @Binds
        fun provideEpisodeInteractor(episodeInteractor: EpisodeInteractor): IEpisodeInteractor

        @Singleton
        @Binds
        fun provideLocationInteractor(locationInteractor: LocationInteractor): ILocationInteractor

    }
}