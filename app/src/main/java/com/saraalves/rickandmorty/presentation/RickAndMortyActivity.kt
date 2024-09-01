package com.saraalves.rickandmorty.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.ActivityRickAndMortyBinding
import com.saraalves.rickandmorty.presentation.character.fragment.CharacterFragment
import com.saraalves.rickandmorty.presentation.episodes.EpisodesFragment
import com.saraalves.rickandmorty.presentation.location.LocationFragment

class RickAndMortyActivity : AppCompatActivity(R.layout.activity_rick_and_morty) {

    private val binding by lazy { ActivityRickAndMortyBinding.inflate(layoutInflater) }

    private lateinit var characterFragment: CharacterFragment
    private lateinit var episodeFragment: EpisodesFragment
    private lateinit var locationFragment: LocationFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        characterFragment = CharacterFragment()
        locationFragment = LocationFragment()
        episodeFragment = EpisodesFragment()

        setCurrentFragment(characterFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.person  -> setCurrentFragment(characterFragment)
                R.id.episodes -> setCurrentFragment(episodeFragment)
                R.id.location -> setCurrentFragment(locationFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}