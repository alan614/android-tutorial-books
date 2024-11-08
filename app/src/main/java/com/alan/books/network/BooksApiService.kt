package com.alan.books.network

import com.alan.books.model.Book
import com.alan.books.model.BookShelf
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApiService {
    @GET("v1/volumes")
    suspend fun getBooks(@Query(value = "q") query: String): BookShelf

    @GET("v1/volumes/{id}")
    suspend fun getBook(@Path(value = "id") id: String): Book
}
/*

private val baseUrl: String = "https://www.googleapis.com/books/";

private val retrofit: Retrofit = Retrofit
    .Builder()
    .addConverterFactory(
        Json {ignoreUnknownKeys = true}.asConverterFactory(
            contentType = "application/json".toMediaType()
        )
    )
    .baseUrl(baseUrl)
    .build()

object BooksApi {
    val retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
}*/
