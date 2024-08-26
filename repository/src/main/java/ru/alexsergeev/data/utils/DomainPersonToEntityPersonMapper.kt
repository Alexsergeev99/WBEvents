package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.FullName
import ru.alexsergeev.data.entity.PersonEntity
import ru.alexsergeev.data.entity.Phone
import ru.alexsergeev.domain.domain.models.PersonDomainModel

internal class DomainPersonToEntityPersonMapper(
) : Mapper<PersonDomainModel, PersonEntity> {
    override fun map(input: PersonDomainModel): PersonEntity = with(input) {
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
            tags = tags
        )
    }
}