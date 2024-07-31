package ru.alexsergeev.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.repository.GroupRepository
import ru.alexsergeev.domain.repository.PersonProfileRepository
import ru.alexsergeev.repository.repository.EventRepositoryImpl
import ru.alexsergeev.repository.repository.GroupRepositoryImpl
import ru.alexsergeev.repository.repository.PersonProfileRepositoryImpl

val dataModule = module{
    singleOf(::PersonProfileRepositoryImpl) bind PersonProfileRepository::class
    singleOf(::EventRepositoryImpl) bind EventRepository::class
    singleOf(::GroupRepositoryImpl) bind GroupRepository::class
}