package com.example.bsuirjournal.ui

import androidx.lifecycle.ViewModel
import com.example.bsuirjournal.data.DataSource
import com.example.bsuirjournal.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(UiState(groupNumberOptions = DataSource.groupNumberOptions))

    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun setGroup(groupNumber: String) {
        _uiState.update { currentState ->
            currentState.copy(
                group = groupNumber,
            )
        }
    }
}