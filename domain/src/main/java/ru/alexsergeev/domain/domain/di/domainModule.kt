package ru.alexsergeev.testwb.di.modules

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.alexsergeev.domain.usecases.interfaces.AddPersonToVisitorsUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetCommunitiesListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetCommunityUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventVisitorsListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventsListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetMyEventsListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetPersonProfileUseCase
import ru.alexsergeev.domain.usecases.interfaces.RemovePersonFromVisitorsUseCase
import ru.alexsergeev.domain.usecases.interfaces.SetPersonProfileUseCase
import ru.alexsergeev.domain.usecases.interfaces.ValidateCodeUseCase
import ru.alexsergeev.domain.usecases.implementation.AddPersonToVisitorsUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.GetCommunitiesListUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.GetCommunityUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.GetEventUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.GetEventVisitorsListUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.GetEventsListUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.GetMyEventsListUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.GetPersonProfileUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.RemovePersonFromVisitorsUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.SetPersonProfileUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.ValidateCodeUseCaseImpl
import ru.alexsergeev.domain.usecases.interfaces.GetMyEventUseCase
import ru.alexsergeev.domain.usecases.implementation.GetMyEventUseCaseImpl


val domainModule = module {
    factoryOf(::GetEventsListUseCaseImpl) bind GetEventsListUseCase::class
    factoryOf(::GetEventUseCaseImpl) bind GetEventUseCase::class
    factoryOf(::GetCommunitiesListUseCaseImpl) bind GetCommunitiesListUseCase::class
    factoryOf(::GetCommunityUseCaseImpl) bind GetCommunityUseCase::class
    factoryOf(::GetPersonProfileUseCaseImpl) bind GetPersonProfileUseCase::class
    factoryOf(::SetPersonProfileUseCaseImpl) bind SetPersonProfileUseCase::class
    factoryOf(::GetMyEventsListUseCaseImpl) bind GetMyEventsListUseCase::class
    factoryOf(::GetMyEventUseCaseImpl) bind GetMyEventUseCase::class
    factoryOf(::GetEventVisitorsListUseCaseImpl) bind GetEventVisitorsListUseCase::class
    factoryOf(::ValidateCodeUseCaseImpl) bind ValidateCodeUseCase::class
    factoryOf(::AddPersonToVisitorsUseCaseImpl) bind AddPersonToVisitorsUseCase::class
    factoryOf(::RemovePersonFromVisitorsUseCaseImpl) bind RemovePersonFromVisitorsUseCase::class

}