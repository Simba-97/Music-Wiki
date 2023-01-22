package com.simba.musicwiki.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.simba.musicwiki.databinding.AlbumsFragmentBinding
import com.simba.musicwiki.ui.adapters.AlbumItemAdapter
import com.simba.musicwiki.ui.viewModels.MusicEvent
import com.simba.musicwiki.ui.viewModels.MusicWikiViewModel
import com.simba.musicwiki.utils.showToastMessage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumsFragment(tag: String) : Fragment() {

    private var _binding: AlbumsFragmentBinding? = null
    private val binding get() = _binding!!

    private val genre = tag

    private val musicWikiViewModel: MusicWikiViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AlbumsFragmentBinding.inflate(inflater, container, false)
        musicWikiViewModel.onTriggerEvent(
            MusicEvent.GetDetailsOfAlbum(tag = genre)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObserver()
    }

    private fun subscribeObserver() {
        musicWikiViewModel.uiState.asLiveData().observe(viewLifecycleOwner) { uiState ->
            uiState.albumDetails?.let {
                binding.rvAlbums.adapter = it.albums?.album?.let { it1 -> AlbumItemAdapter(it1) }
                binding.rvAlbums.layoutManager = GridLayoutManager(context, 2)
            }

            uiState.message?.let {
                requireActivity().showToastMessage(message = it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}