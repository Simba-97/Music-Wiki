package com.simba.musicwiki.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.simba.musicwiki.databinding.ArtistsFragmentBinding
import com.simba.musicwiki.ui.adapters.AlbumItemAdapter
import com.simba.musicwiki.ui.adapters.ArtistItemAdapter
import com.simba.musicwiki.ui.viewModels.MusicEvent
import com.simba.musicwiki.ui.viewModels.MusicWikiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistsFragment(tag: String) : Fragment() {

    private var _binding: ArtistsFragmentBinding? = null
    private val binding get() = _binding!!

    private val genre = tag

    private val musicWikiViewModel: MusicWikiViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ArtistsFragmentBinding.inflate(inflater, container, false)
        musicWikiViewModel.onTriggerEvent(
            MusicEvent.GetDetailsOfArtists(tag = genre)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObserver()
    }

    private fun subscribeObserver() {
        musicWikiViewModel.uiState.asLiveData().observe(viewLifecycleOwner) { uiState ->
            uiState.artistDetails?.let {
                binding.rvArtists.adapter =
                    it.topArtists?.artist?.let { it1 -> ArtistItemAdapter(it1) }
                binding.rvArtists.layoutManager = GridLayoutManager(context, 2)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}