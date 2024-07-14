package ru.alexsergeev.testwb.repository

import ru.alexsergeev.testwb.dto.EventModel
import ru.alexsergeev.testwb.dto.PersonModel

interface BaseRepository {
    fun getPersonData(): PersonModel

    fun getEventsList(): List<EventModel>
}