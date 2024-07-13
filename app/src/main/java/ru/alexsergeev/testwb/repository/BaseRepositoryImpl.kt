package ru.alexsergeev.testwb.repository

import ru.alexsergeev.testwb.dto.PersonModel

class BaseRepositoryImpl : BaseRepository {

    override fun getPersonData(): PersonModel = PersonModel("Саша Сергеев", "+7 999 999 99-99")

}