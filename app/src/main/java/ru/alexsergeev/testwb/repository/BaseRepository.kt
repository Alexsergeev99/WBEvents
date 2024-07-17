package ru.alexsergeev.testwb.repository

import ru.alexsergeev.testwb.dto.EventModel
import ru.alexsergeev.testwb.dto.GroupModel
import ru.alexsergeev.testwb.dto.PersonModel

interface BaseRepository {
    fun getPersonData(): PersonModel

    fun setPersonData(name: String, phone: String, avatar: String)

    fun getEventsList(): List<EventModel>

    fun getGroups(): List<GroupModel>
}