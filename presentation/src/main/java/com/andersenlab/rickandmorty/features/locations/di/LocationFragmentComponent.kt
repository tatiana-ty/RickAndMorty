package com.andersenlab.rickandmorty.features.locations.di

import androidx.lifecycle.ViewModel
import com.andersenlab.rickandmorty.di.annotation.ViewModelKey
import com.andersenlab.rickandmorty.features.locations.location.LocationFragment
import com.andersenlab.rickandmorty.features.locations.location.LocationViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap

@Subcomponent(modules = [LocationFragmentModule::class])
interface LocationFragmentComponent {
    fun inject(locationFragment: LocationFragment)
}

@Module
interface LocationFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(LocationViewModel::class)
    fun bindViewModel(viewModel: LocationViewModel): ViewModel

}