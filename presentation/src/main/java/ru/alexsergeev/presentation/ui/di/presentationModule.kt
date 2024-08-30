package ru.alexsergeev.testwb.di.modules

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.alexsergeev.presentation.ui.utils.DomainCommunityListToUiCommunityListMapper
import ru.alexsergeev.presentation.ui.utils.DomainEventListToUiEventListMapper
import ru.alexsergeev.presentation.ui.utils.DomainEventToUiEventMapper
import ru.alexsergeev.presentation.ui.utils.DomainGroupToUiGroupMapper
import ru.alexsergeev.presentation.ui.utils.DomainPersonToUiPersonMapper
import ru.alexsergeev.presentation.ui.utils.UiEventToDomainEventMapper
import ru.alexsergeev.presentation.ui.utils.UiGroupToDomainGroupMapper
import ru.alexsergeev.presentation.ui.utils.UiPersonToDomainPersonMapper
import ru.alexsergeev.presentation.ui.viewmodel.ChangeTagsScreenViewModel
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
    viewModelOf(::ChangeTagsScreenViewModel)

    singleOf(::DomainEventToUiEventMapper)
    singleOf(::DomainEventListToUiEventListMapper)
    singleOf(::DomainGroupToUiGroupMapper)
    singleOf(::DomainCommunityListToUiCommunityListMapper)
    singleOf(::DomainPersonToUiPersonMapper)
    singleOf(::UiEventToDomainEventMapper)
    singleOf(::UiPersonToDomainPersonMapper)
    singleOf(::UiGroupToDomainGroupMapper)

}

