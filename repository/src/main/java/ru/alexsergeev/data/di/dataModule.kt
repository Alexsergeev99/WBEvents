package ru.alexsergeev.data.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.alexsergeev.data.db.AppDb.Companion.buildDatabase
import ru.alexsergeev.data.db.AppDb.Companion.provideDao
import ru.alexsergeev.data.utils.DataPersonToDomainPersonMapperWithParams
import ru.alexsergeev.data.utils.DataPersonToDomainPersonMapper
import ru.alexsergeev.data.utils.DomainEventToEntityEventMapperWithParams
import ru.alexsergeev.data.utils.DomainEventToEntityEventMapper
import ru.alexsergeev.data.utils.DomainEventToMyEventEntityMapper
import ru.alexsergeev.data.utils.DomainPersonToEntityPersonMapperWithParams
import ru.alexsergeev.data.utils.DomainPersonToEntityPersonMapper
import ru.alexsergeev.data.utils.EntityEventListToDomainEventListMapper
import ru.alexsergeev.data.utils.EntityEventToDomainEventMapperWithParams
import ru.alexsergeev.data.utils.EntityEventToDomainEventMapper
import ru.alexsergeev.data.utils.MyEntityEventListToDomainEventListMapper
import ru.alexsergeev.data.utils.MyEventEntityToDomainEventMapper
import ru.alexsergeev.data.utils.DomainGroupToEntityGroupMapper
import ru.alexsergeev.data.utils.EntityGroupToDomainGroupMapper
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

    singleOf(::EntityEventToDomainEventMapperWithParams)
    singleOf(::EntityEventToDomainEventMapper)
    singleOf(::EntityEventListToDomainEventListMapper)
    singleOf(::MyEventEntityToDomainEventMapper)
    singleOf(::MyEntityEventListToDomainEventListMapper)
    singleOf(::DomainEventToMyEventEntityMapper)
    singleOf(::DomainPersonToEntityPersonMapperWithParams)
    singleOf(::DataPersonToDomainPersonMapperWithParams)
    singleOf(::DomainPersonToEntityPersonMapper)
    singleOf(::DataPersonToDomainPersonMapper)
    singleOf(::DomainEventToEntityEventMapperWithParams)
    singleOf(::DomainEventToEntityEventMapper)
    singleOf(::DomainGroupToEntityGroupMapper)
    singleOf(::EntityGroupToDomainGroupMapper)

    single { buildDatabase(androidContext()) }
    single { provideDao(get()) }
}