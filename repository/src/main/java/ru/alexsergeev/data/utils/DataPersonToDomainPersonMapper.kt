package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.PersonEntity
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone

internal class DataPersonToDomainPersonMapper(
    private val entityGroupToDomainGroupMapper: EntityGroupToDomainGroupMapper
) : Mapper<PersonEntity, PersonDomainModel> {
    override fun map(input: PersonEntity): PersonDomainModel = with(input) {
        val communitiesDomain = mutableListOf<GroupDomainModel>()
        input.communities.communities.forEach {
            communitiesDomain.add(entityGroupToDomainGroupMapper.map(it))
        }
        PersonDomainModel(
            FullName(
                firstName = input.name.firstName,
                secondName = input.name.secondName
            ),
            Phone(input.phone.countryCode, input.phone.basicNumber),
            avatar,
            tags,
            city,
            info,
            communitiesDomain
        )
    }
}