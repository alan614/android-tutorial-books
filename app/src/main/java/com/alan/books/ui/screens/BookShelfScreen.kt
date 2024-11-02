package com.alan.books.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
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
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.alan.books.model.Book
import com.alan.books.model.BookShelf
import com.alan.books.model.ImageLinks
import com.alan.books.model.Info
import com.alan.books.ui.theme.BooksTheme

@Composable
fun BookShelfScreen(
    shelf: BookShelf,
    bookClick: (Book) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 8.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 8.dp),
    ) {
        items(items = shelf.books) { book ->
            BookCard(
                book = book,
                bookClick = bookClick
            )
        }
    }
}

@Composable
fun BookScreen(
    book: Book,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 8.dp)
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(color = MaterialTheme.colorScheme.primaryContainer)
            .verticalScroll(rememberScrollState())
            .padding(contentPadding)
    ) {
        Text(
            text = book.info.title,
            style = MaterialTheme.typography.titleLarge
        )

        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(book.info.imageLinks?.large?.replace("http", "https"))
                .crossfade(true)
                .build(),
            contentDescription = book.info.title
        )

        Text(
            text = book.info.description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun BookCard(
    book: Book,
    bookClick: (Book) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = Modifier.fillMaxWidth()
            .clickable(
                onClick = { bookClick(book) }
            )
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
            id = "1234",
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
            bookClick = {}
        )
    }
}

@Composable
@Preview
fun BookScreenPreview() {
    val book: Book = Book(
        id = "1234",
        link = "https://applink.test",
        info = Info(
            title = "Introduction to Jazz History",
            description = "For courses in Introduction to Jazz and Jazz History. Widely adopted for its well-balanced approach this classic chronological survey of jazz history brings the various historical styles to life by exploring them through the lives of the musicians and a study of their recordings.",
            publisher = "Pearson",
            imageLinks = ImageLinks(
                thumbnail = "http://books.google.com/books/content?id=AycJAQAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api",
                smallThumbnail = "http://books.google.com/books/content?id=AycJAQAAMAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
                small = "http://books.google.com/books/publisher/content?id=EPUTEAAAQBAJ&printsec=frontcover&img=1&zoom=2&edge=curl&imgtk=AFLRE72HjGlbw1UCxb8Jdj_laKCc1JxARmgQ_IiVoNi2Zfaf4rFNXWDVx5Fv6xSIP7qWTJHZb6hFzd6huR8OEcDN2i7Cvu2p9QtOxPjvFI_qaJdmT3-_WQp24CCjATiGvvcEwxoFy4O9&source=gbs_api",
                medium = "http://books.google.com/books/publisher/content?id=EPUTEAAAQBAJ&printsec=frontcover&img=1&zoom=3&edge=curl&imgtk=AFLRE71Lnc0rac2jhcj4FGnxl3TGXjVBbTIiRb3EwTZ5Z3kXfyaNx03YtYhPikq9g3Qi0AqHloz8pmJLaE9TigFTGAeqYYnwheh-W64EJ2BNFCKlaYSlv42QPkpx8_d0TOeJ8w3bDjta&source=gbs_api",
                large = "http://books.google.com/books/publisher/content?id=EPUTEAAAQBAJ&printsec=frontcover&img=1&zoom=4&edge=curl&imgtk=AFLRE72G3yaw7MZpq35_t1z1cEvSkfdUH6cov51rPsjSdUIY1LTmeYaREK6Pj7aSImiX5__Jdz7QsQ5fMONC5Kl6diVYSx7ZGF95LO9vtq2weQliYbf8NhHP3tZMZRn0-BkGFWNNutUj&source=gbs_api",
                extraLarge = "http://books.google.com/books/publisher/content?id=EPUTEAAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE71RJI5nfukT-Fyxxh8eeMw83usT6KbOLn-struMuyBdct_BRWhL8kFNa16VdJ9IbTi0DKA-igguoId7oVgpNHBM0cHtQB_StkCV304INjdHcAljuWqsdFaUdC07zhIZhrm492zZ&source=gbs_api",
            )
        )
    )

    BooksTheme {
        BookScreen(
            book = book,
        )
    }
}