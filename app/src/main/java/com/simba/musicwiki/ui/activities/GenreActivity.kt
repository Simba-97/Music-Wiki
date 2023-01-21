package com.simba.musicwiki.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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

        initViews()
    }

    private fun initViews() {
        initTabLayout()
    }

    private fun initTabLayout() {
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
        binding.vpProfile.adapter = ProfileTabAdapter(this as AppCompatActivity)
        tabLayoutMediator.attach()
    }
}