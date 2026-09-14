package cl.uct.ojociudadano.data.remote.dto

data class IncidentDto(
    val id: String,
    val title: String,
    val description: String,
    val status: String,
    val latitude: Double,
    val longitude: Double
)
