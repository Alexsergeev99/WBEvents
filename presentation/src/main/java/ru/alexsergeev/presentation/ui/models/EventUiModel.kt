package ru.alexsergeev.domain.domain.models

data class EventUiModel(
    val id: Int,
    val title: String?,
    val date: String?,
    val city: String?,
    val isFinished: Boolean = false,
    val meetingAvatar: String,
    val chips: List<String>,
    val imageUrl: String = "https://static.tildacdn.com/tild3062-6662-4137-a535-373262643465/msc.jpg"
)
    fun mapperFromEventDomainModel(eventDomainModel: EventDomainModel): EventUiModel  {
        return EventUiModel(
            id = eventDomainModel.id,
            title = eventDomainModel.title,
            city = eventDomainModel.city,
            date = eventDomainModel.date,
            isFinished = eventDomainModel.isFinished,
            meetingAvatar = eventDomainModel.meetingAvatar,
            chips = eventDomainModel.chips,
            imageUrl = eventDomainModel.imageUrl,
        )
    }

