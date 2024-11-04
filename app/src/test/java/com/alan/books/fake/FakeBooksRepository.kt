package com.alan.books.fake

import com.alan.books.data.BooksRepository
import com.alan.books.model.Book
import com.alan.books.model.BookShelf

class FakeBooksRepository: BooksRepository {
    override suspend fun getBooks(query: String): BookShelf {
        return FakeDataSource.sampleBookShelf
    }

    override suspend fun getBook(id: String): Book {
        return FakeDataSource.sampleBookShelf.books.first()
    }
}