package ru.alexsergeev.testwb.di.modules

import org.koin.dsl.module
import ru.alexsergeev.domain.domain.repository.BaseRepository
import ru.alexsergeev.testwb.data.repository.BaseRepositoryImpl

val domainModule = module{
    single<BaseRepository> {
        BaseRepositoryImpl()
    }
}