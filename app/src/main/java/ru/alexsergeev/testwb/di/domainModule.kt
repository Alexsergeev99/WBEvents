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
    factoryOf(::GetEventsListUseCaseImpl) bind GetEventsListUseCase::class
    factoryOf(::GetEventUseCaseImpl) bind GetEventUseCase::class
    factoryOf(::GetCommunitiesListUseCaseImpl) bind GetCommunitiesListUseCase::class
    factoryOf(::GetCommunityUseCaseImpl) bind GetCommunityUseCase::class
    factoryOf(::GetPersonProfileUseCaseImpl) bind GetPersonProfileUseCase::class
    factoryOf(::SetPersonProfileUseCaseImpl) bind SetPersonProfileUseCase::class
    factoryOf(::GetMyEventsListUseCaseImpl) bind GetMyEventsListUseCase::class
    factoryOf(::GetEventVisitorsListUseCaseImpl) bind GetEventVisitorsListUseCase::class
    factoryOf(::ValidateCodeUseCaseImpl) bind ValidateCodeUseCase::class
    factoryOf(::AddPersonToVisitorsUseCaseImpl) bind AddPersonToVisitorsUseCase::class
    factoryOf(::RemovePersonFromVisitorsUseCaseImpl) bind RemovePersonFromVisitorsUseCase::class

}