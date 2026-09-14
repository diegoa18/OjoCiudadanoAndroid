package cl.uct.ojociudadano.data.model

data class Notification(
    val id: String,
    val title: String,
    val message: String,
    val read: Boolean
)
