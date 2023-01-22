package com.simba.musicwiki.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.simba.musicwiki.R
import com.simba.musicwiki.databinding.ActivityAlbumDetailsBinding
import com.simba.musicwiki.domain.AlbumParams
import com.simba.musicwiki.ui.viewModels.MusicEvent
import com.simba.musicwiki.ui.viewModels.MusicWikiViewModel
import com.simba.musicwiki.utils.BindingUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumDetailsBinding

    private val musicWikiViewModel: MusicWikiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val albumName = intent.getStringExtra("ALBUM_NAME")
        val artistName = intent.getStringExtra("ARTIST_NAME")

        musicWikiViewModel.onTriggerEvent(
            MusicEvent.GetAlbum(
                AlbumParams(
                    album = albumName!!,
                    artist = artistName!!
                )
            )
        )

        subscribeObserver()
    }

    private fun subscribeObserver() {
        musicWikiViewModel.uiState.asLiveData().observe(this) { uiState ->
            uiState.albumResponse?.let {
                BindingUtils.loadAndBindImage(
                    binding.ivAlbumImage,
                    it.album.image?.get(it.album.image.size - 1)?.text
                )
                binding.albumName.text = it.album.name
                binding.artistName.text = it.album.artist
                it.album.tags?.tag?.map { tag ->
                    tag.name?.let { it1 -> addChip(it1) }
                }
                binding.summary.text = it.album.wiki?.summary ?: "No description found"
            }
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
}