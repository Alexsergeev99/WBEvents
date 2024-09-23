package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone

internal class DomainPersonToUiPersonMapperWithParams : Mapper<PersonDomainModel, PersonUiModel> {
    override fun map(input: PersonDomainModel): PersonUiModel = with(input) {
        PersonUiModel(
            id = id,
            name = FullName(firstName = input.name.firstName, secondName = input.name.secondName),
            phone = Phone(input.phone.countryCode, input.phone.basicNumber),
            avatar = avatar,
            tags = tags,
            city = city,
            info = info,
            myEvents = myEvents,
            myCommunities = myCommunities
        )
    }
}