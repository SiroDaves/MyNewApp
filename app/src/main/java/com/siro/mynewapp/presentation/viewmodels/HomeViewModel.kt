package com.siro.mynewapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siro.mynewapp.data.models.Fruit
import com.siro.mynewapp.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepo: HomeRepository,
) : ViewModel() {
    private val _isLoggedIn: MutableStateFlow<Boolean> = MutableStateFlow(false)
    var isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    private val _fruits = MutableStateFlow<List<Fruit>>(emptyList())
    val fruits: StateFlow<List<Fruit>> get() = _fruits

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        _isLoggedIn.value = true
    }

    fun setEditing() {
        _uiState.tryEmit(HomeUiState.Editing)
    }

    fun fetchData() {
        _uiState.tryEmit(HomeUiState.Loading)
        viewModelScope.launch {
            homeRepo.fetchAllFruits().catch { exception ->
                Log.d("TAG", "Fetching data failed: $exception")
                _uiState.tryEmit(HomeUiState.Error("Fetching data failed: $exception"))
            }.collect { fruitItems ->
                _fruits.value = fruitItems
                _uiState.tryEmit(HomeUiState.Loaded)
            }
        }
    }

    fun saveData(fruit: Fruit) {
        _uiState.tryEmit(HomeUiState.Loading)
        viewModelScope.launch {
            homeRepo.saveFruit(fruit)
            _uiState.tryEmit(HomeUiState.Loaded)
        }

    }
}

sealed class HomeUiState {
    object Loading : HomeUiState()
    object Loaded : HomeUiState()
    object Editing : HomeUiState()
    class Error(val errorMessage: String) : HomeUiState()
}