package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.presentation.ui.models.PersonUiModelMini

internal class UiPersonMiniToDomainPersonMapper : Mapper<PersonUiModelMini, PersonDomainModel> {
    override fun map(input: PersonUiModelMini): PersonDomainModel = with(input) {
        PersonDomainModel(
            FullName(
                firstName = input.name.firstName,
                secondName = input.name.secondName
            ),
            phone = Phone("", ""),
            avatar = avatar,
            tags,
            communities = listOf()
        )
    }
}