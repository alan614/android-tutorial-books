package com.alan.books.data

import com.alan.books.model.Book
import com.alan.books.model.BookShelf
import com.alan.books.network.BooksApiService

interface BooksRepository {
    suspend fun getBooks(query: String): BookShelf
    suspend fun getBook(id: String): Book
}

class NetworkBookRepository(
    private val booksApiService: BooksApiService
): BooksRepository {
    override suspend fun getBooks(query: String) : BookShelf = booksApiService.getBooks(query)

    override suspend fun getBook(id: String) : Book = booksApiService.getBook(id)
}