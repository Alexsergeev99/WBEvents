package ru.alexsergeev.testwb.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.alexsergeev.testwb.repository.BaseRepository
import ru.alexsergeev.testwb.repository.BaseRepositoryImpl
import ru.alexsergeev.testwb.ui.viewmodel.AuthViewModel
import ru.alexsergeev.testwb.ui.viewmodel.PersonProfileViewModel
import ru.alexsergeev.testwb.ui.viewmodel.EventsViewModel
import ru.alexsergeev.testwb.ui.viewmodel.GroupsViewModel

val appModule = module {

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

val authModule = module {

    viewModel<AuthViewModel> {
        AuthViewModel(get())
    }

    single<BaseRepository> {
        BaseRepositoryImpl()
    }
}