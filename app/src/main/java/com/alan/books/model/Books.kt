package com.alan.books.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookShelf(
    @SerialName(value = "items")
    val books: List<Book>,
)

@Serializable
data class Book(
    @SerialName(value = "selfLink")
    val link: String,
    @SerialName(value = "volumeInfo")
    val info: Info,
)

@Serializable
data class Info(
    val title: String,
    val description: String = "",
    val publisher: String? = "",
    val imageLinks: ImageLinks? = null,
)

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String,
)