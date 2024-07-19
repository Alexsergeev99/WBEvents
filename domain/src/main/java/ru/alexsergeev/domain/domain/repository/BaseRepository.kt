package ru.alexsergeev.domain.domain.repository

import ru.alexsergeev.testwb.data.dto.EventModel
import ru.alexsergeev.testwb.data.dto.GroupModel
import ru.alexsergeev.testwb.data.dto.PersonModel

interface BaseRepository {
    fun getPersonData(): PersonModel

    fun setPersonData(name: String, phone: String, avatar: String)

    fun getEventsList(): List<EventModel>
    fun getEvent(id: Int): EventModel


    fun getGroups(): List<GroupModel>
    fun getGroup(id: Int): GroupModel

    fun checkPhoneLength(length: Int): Boolean
}