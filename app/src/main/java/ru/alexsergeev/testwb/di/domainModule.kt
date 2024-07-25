package ru.alexsergeev.testwb.di.modules

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.alexsergeev.domain.domain.usecases.GetCommunitiesListUseCase
import ru.alexsergeev.domain.domain.usecases.GetCommunityUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventsListUseCase
import ru.alexsergeev.domain.domain.usecases.GetPersonProfileUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventVisitorsListUseCase
import ru.alexsergeev.domain.domain.usecases.GetMyEventsListUseCase
import ru.alexsergeev.domain.domain.usecases.ValidateCodeUseCase
import ru.alexsergeev.domain.domain.usecases.AddPersonToVisitorsUseCase
import ru.alexsergeev.domain.domain.usecases.RemovePersonFromVisitorsUseCase


val domainModule = module {
    factoryOf(::GetEventsListUseCase)
    factoryOf(::GetEventUseCase)
    factoryOf(::GetCommunitiesListUseCase)
    factoryOf(::GetCommunityUseCase)
    factoryOf(::GetPersonProfileUseCase)
    factoryOf(::GetMyEventsListUseCase)
    factoryOf(::GetEventVisitorsListUseCase)
    factoryOf(::ValidateCodeUseCase)
    factoryOf(::AddPersonToVisitorsUseCase)
    factoryOf(::RemovePersonFromVisitorsUseCase)

}