package ru.alexsergeev.testwb.di.modules

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.alexsergeev.testwb.ui.viewmodel.CodeScreenViewModel
import ru.alexsergeev.testwb.ui.viewmodel.DetailEventViewModel
import ru.alexsergeev.testwb.ui.viewmodel.DetailGroupViewModel
import ru.alexsergeev.testwb.ui.viewmodel.EditProfileViewModel
import ru.alexsergeev.testwb.ui.viewmodel.EventsViewModel
import ru.alexsergeev.testwb.ui.viewmodel.GroupsViewModel
import ru.alexsergeev.testwb.ui.viewmodel.InputPhoneNumberViewModel
import ru.alexsergeev.testwb.ui.viewmodel.MyEventsViewModel
import ru.alexsergeev.testwb.ui.viewmodel.PersonProfileViewModel

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

