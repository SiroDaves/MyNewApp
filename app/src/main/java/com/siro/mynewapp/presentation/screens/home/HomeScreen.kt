package com.siro.mynewapp.presentation.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.siro.mynewapp.presentation.screens.home.widgets.*
import com.siro.mynewapp.presentation.viewmodels.*

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val fruits by viewModel.fruits.collectAsState(initial = emptyList())
    val uiState by viewModel.uiState.collectAsState()

    var fetchData by rememberSaveable { mutableStateOf(0) }

    if (fetchData == 0) {
        viewModel.fetchData()
        fetchData = fetchData.inc()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("My Fruits") })
        },
        content = {
            Box(modifier = Modifier.padding(it))
            {
                when (val state = uiState) {
                    is HomeUiState.Error -> {
                        ErrorState(
                            errorMessage = state.errorMessage,
                            onRetry = {}
                        )
                    }

                    HomeUiState.Loaded -> LoadingState("Loading data ...")

                    HomeUiState.Loading -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            contentPadding = PaddingValues(horizontal = 10.dp)
                        ) {
                            items(fruits) { fruit ->
                                FruitItem(
                                    fruit = fruit,
                                    onClicked = { },
                                )
                            }
                        }
                    }

                    HomeUiState.Editing -> TODO()
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.setEditing() }
            ) { Icon(Icons.Filled.Add, "Add") }
        }
    )
}
