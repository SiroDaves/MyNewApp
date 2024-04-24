package com.siro.mynewapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siro.mynewapp.data.models.Fruit
import com.siro.mynewapp.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepo: HomeRepository,
) : ViewModel() {
    private val _isLoggedIn: MutableStateFlow<Boolean> = MutableStateFlow(false)
    var isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    private val _fruits = MutableStateFlow<List<Fruit>>(emptyList())
    val fruits: StateFlow<List<Fruit>> get() = _fruits

    init {
        _isLoggedIn.value = true
    }
}