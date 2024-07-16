package ru.alexsergeev.testwb.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.alexsergeev.testwb.repository.BaseRepository
import ru.alexsergeev.testwb.repository.BaseRepositoryImpl
import ru.alexsergeev.testwb.ui.viewmodel.BaseViewModel

val appModule = module {

    viewModel<BaseViewModel>{
        BaseViewModel(get())
    }

    single<BaseRepository> {
        BaseRepositoryImpl()
    }
}