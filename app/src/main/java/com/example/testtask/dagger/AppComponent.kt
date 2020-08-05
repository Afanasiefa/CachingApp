package com.example.testtask.dagger

import com.example.testtask.dagger.modules.DatabaseModule
import com.example.testtask.dagger.modules.NetworkModule
import com.example.testtask.dagger.modules.viewmodel.ViewModelModule
import com.example.testtask.ui.detailed.DetailedFragment
import com.example.testtask.ui.main.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, NetworkModule::class, DatabaseModule::class])
interface AppComponent {
    fun inject(mainFragment: MainFragment)
    fun inject(detailedFragment: DetailedFragment)
}