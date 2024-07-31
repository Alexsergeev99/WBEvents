package ru.alexsergeev.wbevents.ui.utils

import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.presentation.ui.models.PersonUiModel

internal fun mapperToPersonDomainModel(personUiModel: PersonUiModel): PersonDomainModel {
    return PersonDomainModel(
        name = FullName(personUiModel.name.firstName, personUiModel.name.secondName),
        phone = Phone(personUiModel.phone.countryCode, personUiModel.phone.basicNumber),
        avatar = personUiModel.avatar,
    )
}