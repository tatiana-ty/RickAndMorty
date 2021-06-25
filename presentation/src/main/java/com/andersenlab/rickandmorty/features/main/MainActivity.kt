package com.andersenlab.rickandmorty.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andersenlab.rickandmorty.R
import com.andersenlab.rickandmorty.features.characters.character.CharacterFragment
import com.andersenlab.rickandmorty.features.characters.ui.CharactersFragment
import com.andersenlab.rickandmorty.features.episodes.episode.EpisodeFragment
import com.andersenlab.rickandmorty.features.episodes.ui.EpisodesFragment
import com.andersenlab.rickandmorty.features.locations.location.LocationFragment
import com.andersenlab.rickandmorty.features.locations.ui.LocationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity :
    AppCompatActivity(),
    CharactersFragment.CharactersCallbacks,
    CharacterFragment.CharacterCallbacks,
    LocationsFragment.LocationsCallbacks,
    LocationFragment.LocationCallbacks,
    EpisodesFragment.EpisodesCallbacks,
    EpisodeFragment.EpisodeCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_view_charactes -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.activity_container, CharactersFragment.newInstance())
                        .commitAllowingStateLoss()
                    true
                }
                R.id.bottom_view_locations -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.activity_container, LocationsFragment.newInstance())
                        .commitAllowingStateLoss()
                    true
                }
                R.id.bottom_view_episodes -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.activity_container, EpisodesFragment.newInstance())
                        .commitAllowingStateLoss()
                    true
                }
                else -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.activity_container, CharactersFragment())
                        .commitAllowingStateLoss()
                    true
                }
            }
        }
        bottomNav.selectedItemId = R.id.bottom_view_charactes

        bottomNav.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.bottom_view_charactes -> {
                }
                R.id.bottom_view_locations -> {
                }
                R.id.bottom_view_episodes -> {
                }
            }
        }
    }

    override fun onCharacterItemSelected(characterId: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.activity_container,
                CharacterFragment.newInstance(characterId)
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onEpisodeItemSelected(episodeId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.activity_container,
                EpisodeFragment.newInstance(episodeId)
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onLocationItemSelected(locationId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.activity_container,
                LocationFragment.newInstance(locationId)
            )
            .addToBackStack(null)
            .commit()
    }
}