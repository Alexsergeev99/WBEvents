package ru.alexsergeev.domain.domain.models

data class GroupDomainModel(
    val id: Int,
    val name: String,
    val people: Long,
    val groupLogo: String,
    val info: String,
    val tags: List<String>,
    val communitySubscribers: MutableList<PersonDomainModel> = mutableListOf(),
    val communityEvents: List<Int>
)
