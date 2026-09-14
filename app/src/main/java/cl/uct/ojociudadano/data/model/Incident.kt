package cl.uct.ojociudadano.data.model

data class Incident(
    val id: String,
    val title: String,
    val description: String,
    val status: String,
    val latitude: Double,
    val longitude: Double
)
