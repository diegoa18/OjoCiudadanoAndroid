package cl.uct.ojociudadano.ui.notifications

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.uct.ojociudadano.data.model.Notification
import cl.uct.ojociudadano.data.remote.CreateNotificationRequest
import cl.uct.ojociudadano.data.remote.TechTestClient
import kotlinx.coroutines.launch

@Composable
fun NotificationsScreen(onBack: () -> Unit) {
    val scope = rememberCoroutineScope()
    var message by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var notifications by remember { mutableStateOf(emptyList<Notification>()) }

    fun loadNotifications() {
        scope.launch {
            try {
                notifications = TechTestClient.api.getNotifications()
                status = "Notificaciones cargadas desde Tech-test"
            } catch (_: Exception) {
                status = "No se pudo conectar con Notifications"
            }
        }
    }

    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Notificaciones", style = MaterialTheme.typography.headlineSmall)
        OutlinedTextField(value = message, onValueChange = { message = it }, label = { Text("Mensaje") })
        Button(onClick = {
            scope.launch {
                try {
                    TechTestClient.api.createNotification(CreateNotificationRequest(message))
                    message = ""
                    loadNotifications()
                } catch (_: Exception) {
                    status = "No se pudo enviar la notificación"
                }
            }
        }, enabled = message.isNotBlank()) { Text("Enviar notificación") }
        Button(onClick = ::loadNotifications) { Text("Cargar desde Tech-test") }
        if (status.isNotBlank()) Text(status)
        LazyColumn(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(notifications) { notification -> Card(Modifier.fillMaxWidth()) { Column(Modifier.padding(16.dp)) { Text(notification.message, style = MaterialTheme.typography.titleMedium); Text(notification.createdAt) } } }
        }
        Button(onClick = onBack) { Text("Volver") }
    }
}
