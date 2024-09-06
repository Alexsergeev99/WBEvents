package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.PersonEntity
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone

internal class DataPersonToDomainPersonMapperWithParams : Mapper<PersonEntity, PersonDomainModel> {
    override fun map(input: PersonEntity): PersonDomainModel = with(input) {
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
            myEvents,
            myCommunities
        )
    }
}