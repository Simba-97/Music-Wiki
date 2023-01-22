package com.simba.musicwiki.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.simba.musicwiki.R
import com.simba.musicwiki.databinding.ActivityArtistDetailsBinding
import com.simba.musicwiki.ui.adapters.AlbumItemAdapter
import com.simba.musicwiki.ui.adapters.TrackItemAdapter
import com.simba.musicwiki.ui.viewModels.MusicEvent
import com.simba.musicwiki.ui.viewModels.MusicWikiViewModel
import com.simba.musicwiki.utils.BindingUtils
import com.simba.musicwiki.utils.showProgressBar
import com.simba.musicwiki.utils.showToastMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.ln
import kotlin.math.pow

@AndroidEntryPoint
class ArtistDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistDetailsBinding

    private val musicWikiViewModel: MusicWikiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val artistName = intent.getStringExtra("ARTIST_NAME")
        artistName?.let {
            musicWikiViewModel.onTriggerEvent(
                MusicEvent.GetArtistInfo(
                    artist = it
                )
            )
            musicWikiViewModel.onTriggerEvent(
                MusicEvent.GetArtistTopTracks(
                    artist = it
                )
            )
            musicWikiViewModel.onTriggerEvent(
                MusicEvent.GetArtistTopAlbums(
                    artist = it
                )
            )
        }
        subscribeObserver()
    }

    private fun subscribeObserver() {
        musicWikiViewModel.uiState.asLiveData().observe(this) { uiState ->
            uiState.artistInfoResponse?.let {
                BindingUtils.loadAndBindImage(
                    binding.ivArtistImage,
                    it.artist?.image?.get(it.artist.image.size - 1)?.text
                )
                binding.albumName.text = it.artist?.name ?: "Artist"
                it.artist?.tags?.tag?.map { tag ->
                    tag.name?.let { it1 -> addChip(it1) }
                }
                binding.followers.text =
                    it.artist?.stats?.listeners?.let { it1 -> withSuffix(it1.toLong()) }
                binding.playCount.text =
                    it.artist?.stats?.playcount?.let { it1 -> withSuffix(it1.toLong()) }
                binding.summary.text = it.artist?.bio?.summary ?: "No description found"
            }

            uiState.artistTopAlbumsResponse?.let {
                binding.rvTopAlbums.adapter =
                    it.topAlbums?.album?.let { it1 -> AlbumItemAdapter(it1) }

                val layout = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                binding.rvTopAlbums.layoutManager = layout
            }

            uiState.artistTopTracksResponse?.let {
                binding.rvTopTracks.adapter =
                    it.toptracks?.track?.let { it1 -> TrackItemAdapter(it1) }
                val layout = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                binding.rvTopTracks.layoutManager = layout
            }

            uiState.isDataLoading.let {
                binding.progressBar.showProgressBar(it)
            }
            uiState.message?.let {
                showToastMessage(message = it)
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

    private fun withSuffix(count: Long): String? {
        if (count < 1000) return "" + count
        val exp = (ln(count.toDouble()) / ln(1000.0)).toInt()
        return String.format(
            "%.1f %c",
            count / 1000.0.pow(exp.toDouble()),
            "KMBTPE"[exp - 1]
        )
    }

}