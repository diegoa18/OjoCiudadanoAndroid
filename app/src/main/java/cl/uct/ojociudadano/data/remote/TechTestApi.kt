package cl.uct.ojociudadano.data.remote

import cl.uct.ojociudadano.data.model.Incident
import cl.uct.ojociudadano.data.model.Notification
import cl.uct.ojociudadano.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

data class CreateUserRequest(val name: String)
data class CreateIncidentRequest(val description: String)
data class CreateNotificationRequest(val message: String)

interface TechTestApi {
    @POST("api/test/users")
    suspend fun createUser(@Body request: CreateUserRequest): User

    @POST("api/test/incidents")
    suspend fun createIncident(@Body request: CreateIncidentRequest): Incident

    @GET("api/test/incidents")
    suspend fun getIncidents(): List<Incident>

    @POST("api/test/notifications")
    suspend fun createNotification(@Body request: CreateNotificationRequest): Notification

    @GET("api/test/notifications")
    suspend fun getNotifications(): List<Notification>
}
