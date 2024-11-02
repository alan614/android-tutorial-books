package com.alan.books.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alan.books.data.BooksAppUiState
import com.alan.books.data.BooksScreen
import com.alan.books.model.Book
import com.alan.books.model.BookShelf
import com.alan.books.network.BooksApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BooksUiState {
    data class Success(val bookShelf: BookShelf): BooksUiState
    object Error: BooksUiState
    object Loading: BooksUiState
}

sealed interface ViewBookUiState{
    data class Success(val book: Book): ViewBookUiState
    object Error: ViewBookUiState
    object Loading: ViewBookUiState
}

class BooksViewModel(): ViewModel() {

    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    var viewBooksUiState: ViewBookUiState by mutableStateOf(ViewBookUiState.Loading)
        private set

    private val _uiState = MutableStateFlow(BooksAppUiState(BooksScreen.Home))
    val uiState: StateFlow<BooksAppUiState> = _uiState.asStateFlow()

    var searchTerms by mutableStateOf("")

    init {
        //getBooks("Introduction to Jazz")
    }

    fun getBooks(query: String) {
        viewModelScope.launch {
            booksUiState = BooksUiState.Loading
            booksUiState = try {
                val result = BooksApi.retrofitService.getBooks(query = query)
                BooksUiState.Success(result)
            } catch (e: IOException) {
                BooksUiState.Error
            } catch (e: HttpException) {
                BooksUiState.Error
            }
        }
    }

    fun getBook(book: Book) {
        viewModelScope.launch {
            viewBooksUiState = ViewBookUiState.Loading
            viewBooksUiState = try {
                val result = BooksApi.retrofitService.getBook(book.id)
                ViewBookUiState.Success(result)
            } catch (e: IOException) {
                ViewBookUiState.Error
            } catch (e: HttpException) {
                ViewBookUiState.Error
            }
        }
    }

    fun updateSearchTerms(newSearchTerm: String) {
        searchTerms = newSearchTerm
    }

    fun startSearch() {
        _uiState.update {
            it.copy(
                screen = BooksScreen.BookShelf,
                searchTerms = searchTerms,
            )
        }

        getBooks(searchTerms)
    }

    fun selectBook(book: Book) {
        _uiState.update {
            it.copy(
                screen = BooksScreen.BookView,
                book = book
            )
        }

        getBook(book)
    }

    fun returnToHome() {
        _uiState.update {
            it.copy(
                screen = BooksScreen.Home,
                book = null,
            )
        }
    }
}