package cl.uct.ojociudadano.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import cl.uct.ojociudadano.data.remote.CreateUserRequest
import cl.uct.ojociudadano.data.remote.TechTestClient
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    onReportClick: () -> Unit,
    onReportsClick: () -> Unit,
    onNotificationsClick: () -> Unit
) {
    val scope = rememberCoroutineScope()
    var name by remember { mutableStateOf("") }
    var authMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement =
            Arrangement.spacedBy(16.dp),
        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text("Ojo Ciudadano", style = MaterialTheme.typography.headlineMedium)
        Text("Reporta y revisa incidentes de tu ciudad.", textAlign = TextAlign.Center)

        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Nombre de usuario de prueba") })
        Button(onClick = {
            scope.launch {
                authMessage = "Enviando usuario..."
                authMessage = try {
                    val user = TechTestClient.api.createUser(CreateUserRequest(name))
                    "Usuario ${user.name} creado en Auth (id: ${user.id})"
                } catch (_: Exception) {
                    "No se pudo conectar con Auth"
                }
            }
        }, enabled = name.isNotBlank()) { Text("Crear usuario de prueba") }
        if (authMessage.isNotBlank()) Text(authMessage)

        Button(
            onClick = onReportClick
        ) {
            Text("Reportar incidente")
        }

        Button(
            onClick = onReportsClick
        ) {
            Text("Mis reportes")
        }

        Button(onClick = onNotificationsClick) { Text("Notificaciones") }
    }
}
