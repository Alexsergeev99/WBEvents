package ru.alexsergeev.wbevents.ui.utils

import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone

internal fun mapperFromPersonDomainModel(personDomainModel: PersonDomainModel): PersonUiModel =
    PersonUiModel(
        name = FullName(personDomainModel.name.firstName, personDomainModel.name.secondName),
        phone = Phone(personDomainModel.phone.countryCode, personDomainModel.phone.basicNumber),
        avatar = personDomainModel.avatar,
    )