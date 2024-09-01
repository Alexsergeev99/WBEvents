package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.Communities
import ru.alexsergeev.data.entity.FullName
import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.data.entity.PersonEntity
import ru.alexsergeev.data.entity.Phone
import ru.alexsergeev.domain.domain.models.PersonDomainModel

internal class DomainPersonToEntityPersonMapperWithParams(
    private val domainGroupToEntityGroupMapper: DomainGroupToEntityGroupMapper
) : Mapper<PersonDomainModel, PersonEntity> {
    override fun map(input: PersonDomainModel): PersonEntity = with(input) {
        val communitiesEntity = mutableListOf<GroupEntity>()
        input.communities.forEach {
            communitiesEntity.add(domainGroupToEntityGroupMapper.map(it))
        }
        PersonEntity(
            name = FullName(
                firstName = input.name.firstName,
                secondName = input.name.secondName
            ),
            phone = Phone(
                input.phone.countryCode,
                input.phone.basicNumber
            ),
            avatar = avatar,
            tags = tags,
            city = city,
            info = info,
            communities = Communities(communitiesEntity)
        )
    }
}