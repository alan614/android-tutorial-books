package com.alan.books.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alan.books.R
import com.alan.books.ui.screens.BooksViewModel
import com.alan.books.ui.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name))
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        val booksViewModel: BooksViewModel = viewModel();

        //booksViewModel.getBooks("introduction to jazz")

        HomeScreen(
            booksUiState = booksViewModel.booksUiState,
            contentPadding = innerPadding
        )
    }
}