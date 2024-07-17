package ru.alexsergeev.testwb.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.alexsergeev.testwb.repository.BaseRepository
import ru.alexsergeev.testwb.repository.BaseRepositoryImpl
import ru.alexsergeev.testwb.ui.viewmodel.EventsViewModel
import ru.alexsergeev.testwb.ui.viewmodel.GroupsViewModel
import ru.alexsergeev.testwb.ui.viewmodel.PersonProfileViewModel

val profileModule = module {

    viewModel<PersonProfileViewModel> {
        PersonProfileViewModel(get())
    }

    single<BaseRepository> {
        BaseRepositoryImpl()
    }
}

val eventsModule = module {

    viewModel<EventsViewModel> {
        EventsViewModel(get())
    }

    single<BaseRepository> {
        BaseRepositoryImpl()
    }
}

val groupsModule = module {

    viewModel<GroupsViewModel> {
        GroupsViewModel(get())
    }

    single<BaseRepository> {
        BaseRepositoryImpl()
    }
}