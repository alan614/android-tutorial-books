package com.alan.books.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.imageLoader
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.util.DebugLogger
import com.alan.books.model.Book
import com.alan.books.model.BookShelf
import com.alan.books.model.ImageLinks
import com.alan.books.model.Info
import com.alan.books.ui.theme.BooksTheme

@Composable
fun HomeScreen(
    booksUiState: BooksUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 8.dp)
) {
    

    /*val book = Book(
        link = "https://applink.test",
        info = Info(
            title = "Introduction to Jazz History",
            description = "For courses in Introduction to Jazz and Jazz History. Widely adopted for its well-balanced approach this classic chronological survey of jazz history brings the various historical styles to life by exploring them through the lives of the musicians and a study of their recordings.",
            publisher = "Pearson",
            imageLinks = ImageLinks(
                thumbnail = "http://books.google.com/books/publisher/content?id=EPUTEAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE73jnbVIvp9KE2pmc6EexnfoEqoCdrxQzK0yNYCL2UV9B1V2fuy2WrxbS48UstZ7VRcs_GGVGjmMmluwDeLfznn0IvO6wCtCVSrYJ1zZ2VWNBXP6LRWVpIvFkHBKsWY5D457oZtD&source=gbs_api",
                smallThumbnail = "http://books.google.com/books/publisher/content?id=EPUTEAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&imgtk=AFLRE72tO2YekpH0ehmovbPy9w4Ex4cPsA5Lyby7hm4uojhBuVPVCeh5E9zxKl-nJu_mJekxjXofM0PsoJML6AHjW_CjIFJXgmspe94JXyr24Oz4Xj1cHzIvbw47-4WlED3Gwzm1k0Vi&source=gbs_api",
            )
        )
    )

    BookCard(
        book = book,
        modifier = Modifier.padding(contentPadding)
    )*/

    when (booksUiState) {
        is BooksUiState.Success -> BookShelfScreen(
            shelf = booksUiState.bookShelf,
            contentPadding = contentPadding,
        )

        else-> Text(text = "Loading")
    }

    //use navigation

    //present search box

    //while loading search from google, show loading animation

    //show 2 column LazyColumn

    //View book details
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
) {

}

@Composable
fun BookShelfScreen(
    shelf: BookShelf,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 8.dp)
) {
    println(shelf)
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 8.dp),
    ) {
        items(items = shelf.books) { book ->
            BookCard(
                book = book
            )
        }
    }
}

@Composable
fun BookScreen(
    book: Book,
    modifier: Modifier = Modifier,
) {

}

@Composable
fun BookCard(
    book: Book,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
    ) {
        /*Column() {
            Text(
                text = book.info.title
            )
            if (book.info.imageLinks !== null) {
                Box(

                ) {
                    *//*val imageLoader = LocalContext.current.imageLoader.newBuilder()
                        .logger(DebugLogger())
                        .build()*//*

                    AsyncImage(
                        //imageLoader = imageLoader,
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(book.info.imageLinks.thumbnail)
                            .crossfade(true)
                            .build(),
                        contentDescription = book.info.description,
                        contentScale = ContentScale.Crop,
                        //modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Text(
                text = book.info.description
            )
        }*/

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            //if (book.info.imageLinks !== null) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.width(128.dp).background(color = Color.Red)
                ) {
                    if (book.info.imageLinks !== null) {
                        AsyncImage(
                            //imageLoader = imageLoader,
                            model = ImageRequest.Builder(context = LocalContext.current)
                                .data(book.info.imageLinks.thumbnail.replace("http", "https"))
                                .crossfade(true)
                                .build(),
                            contentDescription = book.info.description,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            //}
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = book.info.title,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = book.info.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 8,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
@Preview
fun BookCardPreview() {
    BooksTheme {
        val book: Book = Book(
            link = "https://applink.test",
            info = Info(
                title = "Introduction to Jazz History",
                description = "For courses in Introduction to Jazz and Jazz History. Widely adopted for its well-balanced approach this classic chronological survey of jazz history brings the various historical styles to life by exploring them through the lives of the musicians and a study of their recordings.",
                publisher = "Pearson",
                imageLinks = ImageLinks(
                    thumbnail = "https://books.google.com/books/content?id=AycJAQAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api",
                    smallThumbnail = "https://books.google.com/books/content?id=AycJAQAAMAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
                )
            )
        )

        BookCard(
            book = book,
        )
    }
}