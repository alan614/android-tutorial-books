package com.alan.books

import android.app.Application
import com.alan.books.data.AppContainer
import com.alan.books.data.DefaultAppContainer

class BooksApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}