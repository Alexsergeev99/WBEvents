package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.presentation.ui.models.PersonUiModel

internal class UiPersonToDomainPersonMapper(
    private val uiGroupToDomainGroupMapper: UiGroupToDomainGroupMapper
) : Mapper<PersonUiModel, PersonDomainModel> {
    override fun map(input: PersonUiModel): PersonDomainModel = with(input) {
        val communitiesDomain = mutableListOf<GroupDomainModel>()
        input.communities.forEach {
            communitiesDomain.add(uiGroupToDomainGroupMapper.map(it))
        }
        PersonDomainModel(
            FullName(
                firstName = input.name.firstName,
                secondName = input.name.secondName
            ),
            Phone(
                input.phone.countryCode,
                input.phone.basicNumber
            ),
            avatar,
            tags,
            city = city,
            info = info,
            communitiesDomain
        )
    }
}