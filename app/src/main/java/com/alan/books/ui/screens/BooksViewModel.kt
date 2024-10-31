package com.alan.books.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alan.books.model.Book
import com.alan.books.model.BookShelf
import com.alan.books.network.BooksApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BooksUiState {
    data class Success(val bookShelf: BookShelf): BooksUiState
    object Error: BooksUiState
    object Loading: BooksUiState
}

class BooksViewModel(): ViewModel() {

    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    init {
        Log.d("VIEWMODEL", "Initialized")
        getBooks("Introduction to Jazz")
    }

    fun getBooks(query: String) {
        //Log.d("VIEWMODEL", "Getting books")
        viewModelScope.launch {
            booksUiState = BooksUiState.Loading
            booksUiState = try {
                val result = BooksApi.retrofitService.getBooks(query = query)
                //Log.d("VIEWMODEL", result.toString())
                BooksUiState.Success(result)
            } catch (e: IOException) {
                //Log.d("VIEWMODEL", "error ${e.message}")
                BooksUiState.Error
            } catch (e: HttpException) {
                //Log.d("VIEWMODEL", "error ${e.message}")
                BooksUiState.Error
            }
        }
    }
}