package com.example.testtask.dagger

import android.app.Application
import com.example.testtask.dagger.modules.DatabaseModule

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .databaseModule(
                DatabaseModule(
                    this
                )
            )
            .build()
    }
}