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
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alan.books.R
import com.alan.books.data.BooksScreen
import com.alan.books.ui.screens.BookScreen
import com.alan.books.ui.screens.BookShelfScreen
import com.alan.books.ui.screens.BooksUiState
import com.alan.books.ui.screens.BooksViewModel
import com.alan.books.ui.screens.HomeScreen
import com.alan.books.ui.screens.ViewBookUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksApp(
    viewModel: BooksViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController(),
) {

    val booksUiState = viewModel.booksUiState
    val viewBooksUiState = viewModel.viewBooksUiState

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

        //val booksViewModel: BooksViewModel = viewModel();

        //booksViewModel.getBooks("introduction to jazz")
        NavHost(
            navController = navHostController,
            startDestination = BooksScreen.Home.name,
        ) {
            composable(route = BooksScreen.Home.name) {
                HomeScreen(
                    //booksUiState = booksViewModel.booksUiState,
                    //booksViewModel = BooksViewModel(),
                    inputText = viewModel.searchTerms,
                    inputTextChange = { viewModel.updateSearchTerms(it) },
                    startSearch = {
                        viewModel.startSearch()
                        navHostController.navigate(BooksScreen.BookShelf.name)
                    },
                    contentPadding = innerPadding
                )
            }

            composable(route = BooksScreen.BookShelf.name) {

                when(booksUiState) {
                    is BooksUiState.Success -> BookShelfScreen(
                        shelf = booksUiState.bookShelf,
                        bookClick = {
                            viewModel.selectBook(it)
                            navHostController.navigate(BooksScreen.BookView.name)
                        },
                        contentPadding = innerPadding
                    )
                    else -> Text(text = "Loading")
                }

            }

            composable(route = BooksScreen.BookView.name) {
                when(viewBooksUiState) {
                    is ViewBookUiState.Success -> BookScreen(
                        book = viewBooksUiState.book,
                        contentPadding = innerPadding,
                    )
                    else -> Text(text = "Loading")
                }
            }
        }
    }
}