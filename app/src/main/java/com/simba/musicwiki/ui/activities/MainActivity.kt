package com.simba.musicwiki.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.simba.musicwiki.R
import com.simba.musicwiki.databinding.ActivityMainBinding
import com.simba.musicwiki.ui.viewModels.MusicEvent
import com.simba.musicwiki.ui.viewModels.MusicWikiViewModel
import com.simba.musicwiki.utils.checkedChipContents
import com.simba.musicwiki.utils.isNetworkConnected
import com.simba.musicwiki.utils.showProgressBar
import com.simba.musicwiki.utils.showToastMessage
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
        binding.chipGroup.setOnCheckedChangeListener { _, _ ->
            val intent = Intent(this, GenreActivity::class.java)
            intent.putExtra("TAG", binding.chipGroup.checkedChipContents())
            startActivity(intent)
            finish()
        }
    }

    private fun addChip(text: String) {
        val chip = Chip(this)
        val drawable =
            ChipDrawable.createFromAttributes(this, null, 0, R.style.Widget_MyApp_Chip_Choice)
        chip.setChipDrawable(drawable)
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

            uiState.message?.let {
                showToastMessage(message = it)
            }

            uiState.isDataLoading.let {
                binding.progressBar.showProgressBar(it)
            }
        }
    }
}