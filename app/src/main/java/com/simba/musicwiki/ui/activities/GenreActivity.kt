package com.simba.musicwiki.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.google.android.material.tabs.TabLayoutMediator
import com.simba.musicwiki.databinding.ActivityGenreBinding
import com.simba.musicwiki.ui.adapters.ProfileTabAdapter
import com.simba.musicwiki.ui.viewModels.MusicEvent
import com.simba.musicwiki.ui.viewModels.MusicWikiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGenreBinding

    private val musicWikiViewModel: MusicWikiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tag = intent.getStringExtra("TAG")
        tag?.let {
            musicWikiViewModel.onTriggerEvent(
                MusicEvent.GetDetailsOfGenre(tag = it)
            )
            initViews(it)
        }
        subscribeObserver()
    }

    private fun subscribeObserver() {
        musicWikiViewModel.uiState.asLiveData().observe(this) { uiState ->
            uiState.genreDetails?.let { genreDetails ->
                binding.genre.text = genreDetails.tag.name
                binding.summary.text = genreDetails.tag.wiki.summary
            }
            uiState.albumDetails?.let {

            }
        }
    }

    private fun initViews(tag: String) {
        initTabLayout(tag)
    }

    private fun initTabLayout(tag: String) {
        val tabLayoutMediator =
            TabLayoutMediator(binding.tlProfile, binding.vpProfile) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "ALBUMS"
                    }
                    1 -> {
                        tab.text = "ARTISTS"
                    }
                    2 -> {
                        tab.text = "TRACKS"
                    }
                }
            }
        binding.vpProfile.adapter = ProfileTabAdapter(this as AppCompatActivity, tag = tag)
        tabLayoutMediator.attach()
    }
}