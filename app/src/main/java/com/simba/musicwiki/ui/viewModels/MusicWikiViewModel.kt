package com.simba.musicwiki.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simba.musicwiki.data.models.ArtistDetailsResponse
import com.simba.musicwiki.data.models.TagListResponse
import com.simba.musicwiki.data.models.album.AlbumDetailsResponse
import com.simba.musicwiki.data.models.genre.GenreDetailsResponse
import com.simba.musicwiki.data.models.tracks.TrackDetailsResponse
import com.simba.musicwiki.domain.*
import com.simba.musicwiki.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicWikiViewModel @Inject constructor(
    private val getTopGenresUseCase: GetTopGenresUseCase,
    private val getGenreDetailsUseCase: GetGenreDetailsUseCase,
    private val getAlbumDetailsUseCase: GetAlbumDetailsUseCase,
    private val getArtistDetailsUseCase: GetArtistDetailsUseCase,
    private val getTrackDetailsUseCase: GetTrackDetailsUseCase
) : ViewModel() {
    private var _uiState = MutableStateFlow(UserUiState())
    val uiState: StateFlow<UserUiState> = _uiState

    fun onTriggerEvent(event: MusicEvent) {
        when (event) {
            is MusicEvent.GetTopGenres -> getTopGenres()
            is MusicEvent.GetDetailsOfAlbum -> getAlbumDetails(event.tag)
            is MusicEvent.GetDetailsOfGenre -> getGenreDetails(event.tag)
            is MusicEvent.GetDetailsOfArtists -> getArtistDetails(event.tag)
            is MusicEvent.GetDetailsOfTracks -> getTrackDetails(event.tag)
        }
    }

    private fun getTrackDetails(tag: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isDataLoading = true) }
            when (val result = getTrackDetailsUseCase(tag)) {
                is Result.Error -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            message = "Something went wrong! Please try again."
                        )
                    }
                }
                Result.Loading -> {
                    _uiState.update { it.copy(isDataLoading = true) }
                }
                is Result.Success -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            trackDetails = result.data
                        )
                    }
                }
            }
        }
    }

    private fun getArtistDetails(tag: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isDataLoading = true) }
            when (val result = getArtistDetailsUseCase(tag)) {
                is Result.Error -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            message = "Something went wrong! Please try again."
                        )
                    }
                }
                Result.Loading -> {
                    _uiState.update { it.copy(isDataLoading = true) }
                }
                is Result.Success -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            artistDetails = result.data
                        )
                    }
                }
            }
        }
    }

    private fun getGenreDetails(tag: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isDataLoading = true) }
            when (val result = getGenreDetailsUseCase(tag)) {
                is Result.Error -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            message = "Something went wrong! Please try again."
                        )
                    }
                }
                Result.Loading -> {
                    _uiState.update { it.copy(isDataLoading = true) }
                }
                is Result.Success -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            genreDetails = result.data
                        )
                    }
                }
            }
        }
    }

    private fun getAlbumDetails(tag: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isDataLoading = true) }
            when (val result = getAlbumDetailsUseCase(tag)) {
                is Result.Error -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            message = "Something went wrong! Please try again."
                        )
                    }
                }
                Result.Loading -> {
                    _uiState.update { it.copy(isDataLoading = true) }
                }
                is Result.Success -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            albumDetails = result.data
                        )
                    }
                }
            }
        }
    }

    private fun getTopGenres() {
        viewModelScope.launch {
            _uiState.update { it.copy(isDataLoading = true) }
            when (val result = getTopGenresUseCase(Unit)) {
                is Result.Error -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            message = "Something went wrong! Please try again."
                        )
                    }
                }
                Result.Loading -> {
                    _uiState.update { it.copy(isDataLoading = true) }
                }
                is Result.Success -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            data = result.data
                        )
                    }
                }
            }
        }
    }
}

data class UserUiState(
    val status: Int? = null,
    val success: Boolean = false,
    val isDataLoading: Boolean = false,
    val data: TagListResponse? = null,
    val message: String? = null,
    val albumDetails: AlbumDetailsResponse? = null,
    val genreDetails: GenreDetailsResponse? = null,
    val artistDetails: ArtistDetailsResponse? = null,
    val trackDetails: TrackDetailsResponse? = null,
)

sealed class MusicEvent {
    object GetTopGenres : MusicEvent()
    data class GetDetailsOfAlbum(val tag: String) : MusicEvent()
    data class GetDetailsOfGenre(val tag: String) : MusicEvent()
    data class GetDetailsOfArtists(val tag: String) : MusicEvent()
    data class GetDetailsOfTracks(val tag: String) : MusicEvent()
}