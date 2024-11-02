package com.alan.books.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
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
    //booksViewModel: BooksViewModel,
    //booksUiState: BooksUiState,
    inputText: String,
    inputTextChange: (String) -> Unit,
    startSearch: () -> Unit,
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

    /*when (booksUiState) {
        is BooksUiState.Success -> BookShelfScreen(
            shelf = booksUiState.bookShelf,
            contentPadding = contentPadding,
        )

        else-> Text(text = "Loading")
    }*/

    SearchScreen(
        //booksViewModel,
        inputText = inputText,
        inputTextChange = inputTextChange,
        startSearchClick = startSearch,
        contentPadding = contentPadding,
    )

    //use navigation

    //present search box

    //while loading search from google, show loading animation

    //show 2 column LazyColumn

    //View book details
}

@Composable
fun SearchScreen(
    inputText: String,
    inputTextChange: (String) -> Unit,
    startSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 8.dp)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxHeight(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(contentPadding)
                .fillMaxWidth(),
        ) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
            ) {

                TextField(
                    value = inputText,
                    onValueChange = inputTextChange,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Search"
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            startSearchClick()
                        }
                    ),
                    label = {
                        Text(text = "What book would you like to search for?")
                    }
                )
            }

            Button(
                onClick = startSearchClick,
                shape = RoundedCornerShape(corner = CornerSize(size = 8.dp))
            ) {
                Text(text = "Search!")
            }
        }
    }
}