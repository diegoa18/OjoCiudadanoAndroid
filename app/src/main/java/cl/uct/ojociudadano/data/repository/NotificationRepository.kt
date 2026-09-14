package cl.uct.ojociudadano.data.repository

import cl.uct.ojociudadano.data.model.Notification

interface NotificationRepository {

    suspend fun getNotifications(): List<Notification>

    suspend fun markAsRead(id: String)
}
