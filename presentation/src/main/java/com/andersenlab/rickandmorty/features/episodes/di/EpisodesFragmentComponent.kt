package com.andersenlab.rickandmorty.features.episodes.di

import androidx.lifecycle.ViewModel
import com.andersenlab.rickandmorty.di.annotation.ViewModelKey
import com.andersenlab.rickandmorty.features.episodes.ui.EpisodesFragment
import com.andersenlab.rickandmorty.features.episodes.viewModel.EpisodesViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap

@Subcomponent(modules = [EpisodesFragmentModule::class])
interface EpisodesFragmentComponent {
    fun inject(episodesFragment: EpisodesFragment)
}

@Module
interface EpisodesFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(EpisodesViewModel::class)
    fun bindViewModel(viewModel: EpisodesViewModel): ViewModel

}