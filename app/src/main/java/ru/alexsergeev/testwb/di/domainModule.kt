package ru.alexsergeev.testwb.di.modules

import org.koin.dsl.module
import ru.alexsergeev.testwb.repository.BaseRepository
import ru.alexsergeev.testwb.repository.BaseRepositoryImpl

val domainModule = module{
    single<BaseRepository> {
        BaseRepositoryImpl()
    }
}