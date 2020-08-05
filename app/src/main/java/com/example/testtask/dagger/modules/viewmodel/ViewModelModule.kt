package com.example.testtask.dagger.modules.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testtask.ui.detailed.DetailedViewModel
import com.example.testtask.ui.main.MainFragmentViewModel
import com.example.testtask.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    internal abstract fun bindMainViewModel(fragmentViewModel: MainFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailedViewModel::class)
    internal abstract fun bindDetailedViewModel(viewModel: DetailedViewModel): ViewModel
    
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}