package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.domain.repository.BaseRepository
import ru.alexsergeev.domain.repository.GroupRepository
import ru.alexsergeev.domain.usecases.interfaces.GetCommunityUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventsListUseCase

internal class DetailGroupViewModel(
    private val getCommunityUseCase: GetCommunityUseCase,
    private val getEventUseCase: GetEventUseCase,
    private val getEventsListUseCase: GetEventsListUseCase,
) : ViewModel() {
    /*
   This VM is not useful right now because we don`t have back and I suppose that in this case use GroupsVM is more attractive.
    */

    /*
    These three funs below are using in GroupsVM now
     */
    fun getCommunity(id: Int) = getCommunityUseCase.invoke(id)
    fun getEventsList() = getEventsListUseCase.invoke()
    fun getEvent(id: Int) = getEventUseCase.invoke(id)
}