package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModelMini
import ru.alexsergeev.presentation.ui.models.Phone

internal class DomainPersonToUiPersonMapper(
    private val domainGroupToUiGroupMapper: DomainGroupToUiGroupMapper
) : Mapper<PersonDomainModel, PersonUiModel> {
    override fun map(input: PersonDomainModel): PersonUiModel = with(input) {
        PersonUiModel(
            FullName(firstName = input.name.firstName, secondName = input.name.secondName),
            Phone(input.phone.countryCode, input.phone.basicNumber),
            avatar, tags, city, info, myEvents, myCommunities
        )
    }
}