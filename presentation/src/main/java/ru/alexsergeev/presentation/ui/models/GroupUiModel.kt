package ru.alexsergeev.presentation.ui.models

internal data class GroupUiModel(
    val id: Int,
    val name: String,
    val people: Long,
    val groupLogo: String,
    val info: String,
    val tags: List<String>,
    val communitySubscribers: List<PersonUiModelMini> = listOf(),
    val communityEvents: List<Int>
)

internal data class GroupUiModelInMainScreen(
    val id: Int,
    val name: String,
    val groupLogo: String,
)

internal data class GroupUiModelInEventScreen(
    val id: Int,
    val name: String,
    val groupLogo: String,
    val info: String,
    val communityEvents: List<EventUiModel>
)


