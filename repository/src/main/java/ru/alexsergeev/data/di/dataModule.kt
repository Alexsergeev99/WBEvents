package ru.alexsergeev.data.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.alexsergeev.data.db.AppDb.Companion.buildDatabase
import ru.alexsergeev.data.db.AppDb.Companion.provideDao
import ru.alexsergeev.data.entity.DataPersonToDomainPersonMapper
import ru.alexsergeev.data.entity.EntityEventToDomainEventMapper
import ru.alexsergeev.data.entity.MyEventEntityToDomainEventMapper
import ru.alexsergeev.data.entity.DomainEventToMyEventEntityMapper
import ru.alexsergeev.data.entity.DomainPersonToDataPersonMapper
import ru.alexsergeev.data.entity.DomainEventToEntityEventMapper
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.repository.GroupRepository
import ru.alexsergeev.domain.repository.PersonProfileRepository
import ru.alexsergeev.repository.repository.EventRepositoryImpl
import ru.alexsergeev.repository.repository.GroupRepositoryImpl
import ru.alexsergeev.repository.repository.PersonProfileRepositoryImpl

val dataModule = module {
    singleOf(::PersonProfileRepositoryImpl) bind PersonProfileRepository::class
    singleOf(::EventRepositoryImpl) bind EventRepository::class
    singleOf(::GroupRepositoryImpl) bind GroupRepository::class

    singleOf(::EntityEventToDomainEventMapper)
    singleOf(::MyEventEntityToDomainEventMapper)
    singleOf(::DomainEventToMyEventEntityMapper)
    singleOf(::DomainPersonToDataPersonMapper)
    singleOf(::DataPersonToDomainPersonMapper)
    singleOf(::DomainEventToEntityEventMapper)

    single { buildDatabase(androidContext()) }
    single { provideDao(get()) }
}