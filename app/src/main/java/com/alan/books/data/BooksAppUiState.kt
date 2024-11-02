package com.alan.books.data

import androidx.annotation.StringRes
import com.alan.books.R
import com.alan.books.model.Book

enum class BooksScreen(@StringRes val title: Int) {
    Home(title = R.string.home),
    BookShelf(title = R.string.bookshelf),
    BookView(title = R.string.view_book),
}

data class BooksAppUiState(
    val screen: BooksScreen,
    val searchTerms: String = "",
    val book: Book? = null,
)