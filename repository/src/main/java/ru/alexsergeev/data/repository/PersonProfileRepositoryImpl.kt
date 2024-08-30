package ru.alexsergeev.repository.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.domain.repository.PersonProfileRepository

internal class PersonProfileRepositoryImpl : PersonProfileRepository {

    private val personDataMutable = MutableStateFlow(
        PersonDomainModel(
            FullName("", ""),
            phone = Phone("+7", ""),
            "https://www.1zoom.me/big2/62/199578-yana.jpg",
            mutableListOf<String>(),
            communities = mutableListOf<GroupDomainModel>()
        )
    )

    override fun getPersonData(): Flow<PersonDomainModel> = flow {
        val person = personDataMutable.value
        emit(person)
    }

    override suspend fun setPersonData(person: PersonDomainModel) {
        personDataMutable.update { person }
    }

    override fun verifyCode(code: Int): Flow<Boolean> = flow {
        val trueCode = code == 6666
        emit(trueCode)
    }
}