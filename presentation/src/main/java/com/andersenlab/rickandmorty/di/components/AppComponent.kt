package com.andersenlab.rickandmorty.di.components

import android.content.Context
import com.andersenlab.rickandmorty.app.App
import com.andersenlab.rickandmorty.di.modules.AppModule
import com.andersenlab.rickandmorty.di.modules.RestModule
import com.andersenlab.rickandmorty.di.modules.ViewModelModule
import com.andersenlab.rickandmorty.features.characters.di.CharacterFragmentComponent
import com.andersenlab.rickandmorty.features.characters.di.CharactersFragmentComponent
import com.andersenlab.rickandmorty.features.episodes.di.EpisodeFragmentComponent
import com.andersenlab.rickandmorty.features.episodes.di.EpisodesFragmentComponent
import com.andersenlab.rickandmorty.features.locations.di.LocationFragmentComponent
import com.andersenlab.rickandmorty.features.locations.di.LocationsFragmentComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    RestModule::class,
    ViewModelModule::class
])
interface AppComponent {

    val context: Context

    val charactersFragmentComponent: CharactersFragmentComponent
    val characterFragmentComponent: CharacterFragmentComponent

    val locationsFragmentComponent: LocationsFragmentComponent
    val locationFragmentComponent: LocationFragmentComponent

    val episodesFragmentComponent: EpisodesFragmentComponent
    val episodeFragmentComponent: EpisodeFragmentComponent
}