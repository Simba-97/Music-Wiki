package com.simba.musicwiki.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.simba.musicwiki.databinding.ArtistsFragmentBinding
import com.simba.musicwiki.ui.activities.ArtistDetailsActivity
import com.simba.musicwiki.ui.adapters.AlbumItemAdapter
import com.simba.musicwiki.ui.adapters.ArtistItemAdapter
import com.simba.musicwiki.ui.viewModels.MusicEvent
import com.simba.musicwiki.ui.viewModels.MusicWikiViewModel
import com.simba.musicwiki.utils.showProgressBar
import com.simba.musicwiki.utils.showToastMessage
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
                val adapter = it.topArtists?.artist?.let { it1 -> ArtistItemAdapter(it1) }
                binding.rvArtists.adapter = adapter
                binding.rvArtists.layoutManager = GridLayoutManager(context, 2)
                adapter?.onItemClick = { artistData ->
                    val intent = Intent(requireContext(), ArtistDetailsActivity::class.java)
                    intent.putExtra("ARTIST_NAME", artistData.name)
                    startActivity(intent)
                }
            }

            uiState.message?.let {
                requireActivity().showToastMessage(message = it)
            }

            uiState.isDataLoading.let {
                binding.progressBar.showProgressBar(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}