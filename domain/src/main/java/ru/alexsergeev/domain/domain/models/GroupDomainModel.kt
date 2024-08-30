package ru.alexsergeev.domain.domain.models

data class GroupDomainModel(
    val id: Int,
    val name: String,
    val people: Long,
    val groupLogo: String,
    val communitySubscribers: List<PersonDomainModel> = listOf(),
    val communityEvents: List<EventDomainModel>
)
