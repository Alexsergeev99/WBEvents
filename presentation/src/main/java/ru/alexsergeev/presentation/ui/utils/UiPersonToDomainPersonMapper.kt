package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModelMini

internal class UiPersonToDomainPersonMapper : Mapper<PersonUiModel, PersonDomainModel> {
    override fun map(input: PersonUiModel): PersonDomainModel = with(input) {
        PersonDomainModel(
            id = id,
            FullName(
                firstName = input.name.firstName,
                secondName = input.name.secondName
            ),
            phone = Phone(
                input.phone.countryCode,
                input.phone.basicNumber),
            avatar = avatar,
            tags = tags,
            info = info,
            city = city,
            myEvents = myEvents,
            myCommunities = myCommunities
        )
    }
}