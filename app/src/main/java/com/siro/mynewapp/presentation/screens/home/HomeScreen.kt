package com.siro.mynewapp.presentation.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.siro.mynewapp.presentation.theme.MyNewAppTheme
import com.siro.mynewapp.presentation.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    //val fruits by viewModel.fruits.collectAsState(initial = emptyList())
    //val isLoggedIn by viewModel.isLoggedIn.collectAsState(false)

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyNewAppTheme {
        Greeting("Android")
    }
}