package com.simba.musicwiki.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simba.musicwiki.data.models.TagListResponse
import com.simba.musicwiki.domain.GetTopGenresUseCase
import com.simba.musicwiki.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicWikiViewModel @Inject constructor(
    private val getTopGenresUseCase: GetTopGenresUseCase
) : ViewModel() {
    private var _uiState = MutableStateFlow(UserUiState())
    val uiState: StateFlow<UserUiState> = _uiState

    fun onTriggerEvent(event: MusicEvent) {
        when (event) {
            is MusicEvent.GetTopGenres -> getTopGenres()
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
    val message: String? = null
)

sealed class MusicEvent {
    object GetTopGenres : MusicEvent()
}