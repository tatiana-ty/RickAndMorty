package com.andersenlab.rickandmorty.di

import android.content.Context
import com.andersenlab.rickandmorty.di.components.AppComponent
import com.andersenlab.rickandmorty.di.components.DaggerAppComponent
import com.andersenlab.rickandmorty.di.modules.AppModule
import com.andersenlab.rickandmorty.di.modules.RestModule
import com.andersenlab.rickandmorty.features.characters.di.CharacterFragmentComponent
import com.andersenlab.rickandmorty.features.characters.di.CharactersFragmentComponent
import com.andersenlab.rickandmorty.features.episodes.di.EpisodeFragmentComponent
import com.andersenlab.rickandmorty.features.episodes.di.EpisodesFragmentComponent
import com.andersenlab.rickandmorty.features.locations.di.LocationFragmentComponent
import com.andersenlab.rickandmorty.features.locations.di.LocationsFragmentComponent

object Injector {

    private lateinit var appComponent: AppComponent

    val charactersFragmentComponent: CharactersFragmentComponent
        get() {
            return appComponent.charactersFragmentComponent
        }
    val characterFragmentComponent: CharacterFragmentComponent
        get() {
            return appComponent.characterFragmentComponent
        }

    val locationsFragmentComponent: LocationsFragmentComponent
        get() {
            return appComponent.locationsFragmentComponent
        }
    val locationFragmentComponent: LocationFragmentComponent
        get() {
            return appComponent.locationFragmentComponent
        }

    val episodesFragmentComponent: EpisodesFragmentComponent
        get() {
            return appComponent.episodesFragmentComponent
        }
    val episodeFragmentComponent: EpisodeFragmentComponent
        get() {
            return appComponent.episodeFragmentComponent
        }


    internal fun initAppComponent(context: Context) {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(context))
            .restModule(RestModule())
            .build()
    }

}