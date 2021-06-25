package com.andersenlab.rickandmorty.features.characters.di

import androidx.lifecycle.ViewModel
import com.andersenlab.rickandmorty.di.annotation.ViewModelKey
import com.andersenlab.rickandmorty.features.characters.character.CharacterFragment
import com.andersenlab.rickandmorty.features.characters.character.CharacterViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap

@Subcomponent(modules = [CharacterFragmentModule::class])
interface CharacterFragmentComponent {
    fun inject(characterFragment: CharacterFragment)
}

@Module
interface CharacterFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    fun bindViewModel(viewModel: CharacterViewModel): ViewModel

}