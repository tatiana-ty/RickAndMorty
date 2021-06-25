package com.andersenlab.domain.interactors

import com.andersenlab.domain.entities.Character
import com.andersenlab.domain.entities.Characters
import com.andersenlab.domain.entities.CharactersFilter
import com.andersenlab.domain.repository.IRepository
import javax.inject.Inject

interface ICharacterInteractor {

    suspend fun getAllCharacters(page: Int, filter: CharactersFilter): Characters

    suspend fun getCharacterById(id: Int): Character

    suspend fun getCharactersById(id: String): List<Character>

}

class CharacterInteractor @Inject constructor(private val repository: IRepository) : ICharacterInteractor {

    override suspend fun getAllCharacters(page: Int, filter: CharactersFilter) = repository.getAllCharacters(page, filter)

    override suspend fun getCharacterById(id: Int): Character = repository.getCharacterById(id)

    override suspend fun getCharactersById(id: String): List<Character> = repository.getCharactersById(id)

}