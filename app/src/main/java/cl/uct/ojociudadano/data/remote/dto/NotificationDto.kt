package cl.uct.ojociudadano.data.remote.dto

data class NotificationDto(
    val id: String,
    val title: String,
    val message: String,
    val read: Boolean
)
