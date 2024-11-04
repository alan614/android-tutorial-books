package com.alan.books

import com.alan.books.data.NetworkBookRepository
import com.alan.books.fake.FakeBooksApiService
import com.alan.books.fake.FakeDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkBooksRepositoryTest {

    @Test
    fun networkBooksRepositoryTest_getBooks_verifyBookShelf() {
        runTest {
            val repository = NetworkBookRepository(
                booksApiService = FakeBooksApiService()
            )

            assertEquals(FakeDataSource.sampleBookShelf, repository.getBooks("testing"));
        }
    }
}