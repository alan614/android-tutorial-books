package com.alan.books.fake

import com.alan.books.model.Book
import com.alan.books.model.BookShelf
import com.alan.books.model.ImageLinks
import com.alan.books.model.Info

object FakeDataSource {
    val sampleBookShelf = BookShelf(
        books = listOf<Book>(
            Book(
                id = "ABC123",
                link = "Introduction to Kotlin",
                info = Info(
                    title = "Introduction to Kotlin",
                    description = "A book about Kotlin",
                    imageLinks = ImageLinks(
                        thumbnail = "https://www.example.com/thumbnail.jpg",
                        smallThumbnail = "https://www.example.com/small.jpg",
                        small = "https://www.example.com/small.jpg",
                        medium = "https://www.example.com/medium.jpg",
                        large = "https://www.example.com/large.jpg",
                    )
                )
            ),
            Book(
                id = "DEF456",
                link = "Introduction to Java",
                info = Info(
                    title = "Introduction to Java",
                    description = "A book about Java",
                    imageLinks = ImageLinks(
                        thumbnail = "https://www.example.com/thumbnail.jpg",
                        smallThumbnail = "https://www.example.com/small.jpg",
                        small = "https://www.example.com/small.jpg",
                        medium = "https://www.example.com/medium.jpg",
                        large = "https://www.example.com/large.jpg",
                    )
                )
            ),
        )
    )
}