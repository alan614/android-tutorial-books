package com.alan.books.fake

import com.alan.books.network.BooksApiService

class FakeBooksApiService: BooksApiService {
    override suspend fun getBooks(query: String) = FakeDataSource.sampleBookShelf
    override suspend fun getBook(id: String) = FakeDataSource.sampleBookShelf.books.first()
}