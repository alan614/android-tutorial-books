package com.alan.books.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.alan.books.BooksApplication
import com.alan.books.data.BooksAppUiState
import com.alan.books.data.BooksRepository
import com.alan.books.data.BooksScreen
import com.alan.books.model.Book
import com.alan.books.model.BookShelf
//import com.alan.books.network.BooksApi
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

class BooksViewModel(
    private val booksRepository: BooksRepository
): ViewModel() {

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
        booksUiState = BooksUiState.Loading
        viewModelScope.launch {
            booksUiState = try {
                //val result = BooksApi.retrofitService.getBooks(query = query)
                val result = booksRepository.getBooks(query = query)
                BooksUiState.Success(result)
            } catch (e: IOException) {
                BooksUiState.Error
            } catch (e: HttpException) {
                BooksUiState.Error
            }
        }
    }

    fun getBook(book: Book) {
        viewBooksUiState = ViewBookUiState.Loading
        viewModelScope.launch {
            viewBooksUiState = try {
                //val result = BooksApi.retrofitService.getBook(book.id)
                val result = booksRepository.getBook(id = book.id)
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

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BooksApplication)
                val booksRepository = application.container.booksRepository
                BooksViewModel(booksRepository = booksRepository)
            }
        }
    }
}