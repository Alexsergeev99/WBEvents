package ru.alexsergeev.domain.domain.models

data class GroupUiModel(
    val id: Int,
    val name: String,
    val people: Long,
    val groupLogo: String,
)

fun mapperFromGroupDomainModel(groupDomainModel: GroupDomainModel): GroupUiModel  {
    return GroupUiModel(
        id = groupDomainModel.id,
        name = groupDomainModel.name,
        people = groupDomainModel.people,
        groupLogo = groupDomainModel.groupLogo,
    )
}
