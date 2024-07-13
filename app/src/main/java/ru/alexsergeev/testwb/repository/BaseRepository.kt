package ru.alexsergeev.testwb.repository

import ru.alexsergeev.testwb.dto.PersonModel

interface BaseRepository {
    fun getPersonData(): PersonModel
}