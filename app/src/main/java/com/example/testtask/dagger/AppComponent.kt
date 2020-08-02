package com.example.testtask.dagger

import com.example.testtask.viewmodel.ViewModelModule
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