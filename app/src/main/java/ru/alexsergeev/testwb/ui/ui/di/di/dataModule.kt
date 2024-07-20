package ru.alexsergeev.testwb.di.modules

import org.koin.dsl.module
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.repository.GroupRepository
import ru.alexsergeev.domain.repository.PersonProfileRepository
import ru.alexsergeev.repository.repository.EventRepositoryImpl
import ru.alexsergeev.repository.repository.GroupRepositoryImpl
import ru.alexsergeev.repository.repository.PersonProfileRepositoryImpl

val dataModule = module{
    single<PersonProfileRepository> {
        PersonProfileRepositoryImpl()
    }
    single<EventRepository> {
        EventRepositoryImpl()
    }
    single<GroupRepository> {
        GroupRepositoryImpl()
    }
}