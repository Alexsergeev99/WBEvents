package ru.alexsergeev.presentation.ui.models

internal data class GroupUiModel(
    val id: Int,
    val name: String,
    val people: Long,
    val groupLogo: String,
    val communityEvents: List<EventUiModel>
)
