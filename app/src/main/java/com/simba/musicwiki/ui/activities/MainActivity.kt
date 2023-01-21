package com.simba.musicwiki.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.google.android.material.chip.Chip
import com.simba.musicwiki.databinding.ActivityMainBinding
import com.simba.musicwiki.ui.viewModels.MusicEvent
import com.simba.musicwiki.ui.viewModels.MusicWikiViewModel
import com.simba.musicwiki.utils.checkedChipContents
import com.simba.musicwiki.utils.isNetworkConnected
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val musicWikiViewModel: MusicWikiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (isNetworkConnected()) {
            musicWikiViewModel.onTriggerEvent(
                MusicEvent.GetTopGenres
            )
        }
        subscribeObserver()
        binding.chipGroup.setOnClickListener {
            musicWikiViewModel.onTriggerEvent(
                MusicEvent.GetDetailsOfGenre(binding.chipGroup.checkedChipContents())
            )
        }
    }

    private fun addChip(text: String) {
        val chip = Chip(this)
        chip.text = text

        binding.chipGroup.addView(chip)
    }

    private fun subscribeObserver() {
        musicWikiViewModel.uiState.asLiveData().observe(this) { uiState ->
            uiState.data?.let {
                it.tags?.tag?.map { tag ->
                    tag.name?.let { it1 -> addChip(it1) }
                }
            }
        }
    }
}