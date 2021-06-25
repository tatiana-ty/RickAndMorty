package com.andersenlab.rickandmorty.features.episodes.di

import androidx.lifecycle.ViewModel
import com.andersenlab.rickandmorty.di.annotation.ViewModelKey
import com.andersenlab.rickandmorty.features.episodes.episode.EpisodeFragment
import com.andersenlab.rickandmorty.features.episodes.episode.EpisodeViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap

@Subcomponent(modules = [EpisodeFragmentModule::class])
interface EpisodeFragmentComponent {
    fun inject(episodeFragment: EpisodeFragment)
}

@Module
interface EpisodeFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(EpisodeViewModel::class)
    fun bindViewModel(viewModel: EpisodeViewModel): ViewModel

}