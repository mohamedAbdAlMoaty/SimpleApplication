package com.example.simpleapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleapplication.data.model.ApodItem
import com.example.simpleapplication.data.repository.ApodRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApodViewModel(private val repository: ApodRepository) : ViewModel() {
    private val _items = MutableStateFlow<List<ApodItem>>(emptyList())
    val items: StateFlow<List<ApodItem>> = _items

    fun fetchApodItems(apiKey: String) {
        viewModelScope.launch {
            if (_items.value.isEmpty()) {
                _items.value = repository.fetchApodItems(apiKey)
            }
        }
    }
}