package com.example.testtask.dagger

import android.app.Application

class App  : Application(){

    companion object{lateinit var appComponent: AppComponent}

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .databaseModule(DatabaseModule(this))
            .build()

    }
}