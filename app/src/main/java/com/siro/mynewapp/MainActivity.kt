package com.siro.mynewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.siro.mynewapp.presentation.screens.home.HomeScreen
import com.siro.mynewapp.presentation.theme.MyNewAppTheme
import com.siro.mynewapp.presentation.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val homeViewModel: HomeViewModel by viewModels()
            MyNewAppTheme {
                HomeScreen(
                    viewModel = homeViewModel,
                )
            }
        }
    }
}
