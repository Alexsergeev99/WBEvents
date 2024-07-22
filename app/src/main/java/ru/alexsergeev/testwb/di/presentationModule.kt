package ru.alexsergeev.testwb.di.modules

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.alexsergeev.presentation.ui.viewmodel.CodeScreenViewModel
import ru.alexsergeev.presentation.ui.viewmodel.DetailEventViewModel
import ru.alexsergeev.presentation.ui.viewmodel.DetailGroupViewModel
import ru.alexsergeev.presentation.ui.viewmodel.EditProfileViewModel
import ru.alexsergeev.presentation.ui.viewmodel.EventsViewModel
import ru.alexsergeev.presentation.ui.viewmodel.GroupsViewModel
import ru.alexsergeev.presentation.ui.viewmodel.InputPhoneNumberViewModel
import ru.alexsergeev.presentation.ui.viewmodel.MyEventsViewModel
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

val presentationModule = module {

    viewModelOf(::PersonProfileViewModel)
    viewModelOf(::EventsViewModel)
    viewModelOf(::GroupsViewModel)
    viewModelOf(::CodeScreenViewModel)
    viewModelOf(::EditProfileViewModel)
    viewModelOf(::DetailEventViewModel)
    viewModelOf(::DetailGroupViewModel)
    viewModelOf(::InputPhoneNumberViewModel)
    viewModelOf(::MyEventsViewModel)

}

