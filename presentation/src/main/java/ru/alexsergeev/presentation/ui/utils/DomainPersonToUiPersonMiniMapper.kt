package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.PersonUiModelMini

internal class DomainPersonToUiPersonMiniMapper : Mapper<PersonDomainModel, PersonUiModelMini> {
    override fun map(input: PersonDomainModel): PersonUiModelMini = with(input) {
        PersonUiModelMini(
            FullName(firstName = input.name.firstName, secondName = input.name.secondName),
            avatar, tags
        )
    }
}