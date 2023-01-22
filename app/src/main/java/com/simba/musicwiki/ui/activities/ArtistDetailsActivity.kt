package com.simba.musicwiki.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.simba.musicwiki.databinding.ActivityArtistDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}