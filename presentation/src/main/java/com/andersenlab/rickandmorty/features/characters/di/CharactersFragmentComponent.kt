package com.andersenlab.rickandmorty.features.characters.di

import androidx.lifecycle.ViewModel
import com.andersenlab.rickandmorty.di.annotation.ViewModelKey
import com.andersenlab.rickandmorty.features.characters.ui.CharactersFragment
import com.andersenlab.rickandmorty.features.characters.viewModel.CharactersViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap

@Subcomponent(modules = [CharactersFragmentModule::class])
interface CharactersFragmentComponent {
    fun inject(charactersFragment: CharactersFragment)
}

@Module
interface CharactersFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    fun bindViewModel(viewModel: CharactersViewModel): ViewModel

}