package ru.alexsergeev.testwb.di.modules

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.alexsergeev.ui.ui.viewmodel.CodeScreenViewModel
import ru.alexsergeev.ui.ui.viewmodel.DetailEventViewModel
import ru.alexsergeev.ui.ui.viewmodel.DetailGroupViewModel
import ru.alexsergeev.ui.ui.viewmodel.EditProfileViewModel
import ru.alexsergeev.ui.ui.viewmodel.EventsViewModel
import ru.alexsergeev.ui.ui.viewmodel.GroupsViewModel
import ru.alexsergeev.ui.ui.viewmodel.InputPhoneNumberViewModel
import ru.alexsergeev.ui.ui.viewmodel.MyEventsViewModel
import ru.alexsergeev.ui.ui.viewmodel.PersonProfileViewModel

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

