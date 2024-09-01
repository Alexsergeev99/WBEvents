package ru.alexsergeev.presentation.ui.models

internal data class GroupUiModel(
    val id: Int,
    val name: String,
    val people: Long,
    val groupLogo: String,
    val info: String,
    val tags: List<String>,
    val communitySubscribers: List<PersonUiModel> = listOf(),
    val communityEvents: List<EventUiModel>
)
