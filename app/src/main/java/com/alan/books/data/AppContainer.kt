package com.alan.books.data

import com.alan.books.network.BooksApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

interface AppContainer {
    val booksRepository: BooksRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://www.googleapis.com/books/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json { ignoreUnknownKeys = true }.asConverterFactory(
                contentType = "application/json".toMediaType()
            )
        )
        .baseUrl(baseUrl)
        .build()

    private val  retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }

    override val booksRepository: BooksRepository by lazy {
        NetworkBookRepository(retrofitService)
    }
}
