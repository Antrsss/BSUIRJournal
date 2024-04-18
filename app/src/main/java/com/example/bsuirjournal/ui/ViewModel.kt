package com.example.bsuirjournal.ui

import androidx.lifecycle.ViewModel
import com.example.bsuirjournal.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(UiState(pickupOptions = pickupOptions()))

    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun setGroup(groupNumber: String) {
        _uiState.update { currentState ->
            currentState.copy(
                group = groupNumber,
            )
        }
    }

    private fun pickupOptions(): List<String> {
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        // add current date and the following 3 dates.
        repeat(4) {
            dateOptions.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return dateOptions
    }
}