package cl.uct.ojociudadano.ui.reports

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
import cl.uct.ojociudadano.data.model.Incident
import cl.uct.ojociudadano.data.remote.TechTestClient
import kotlinx.coroutines.launch

@Composable
fun MyReportsScreen(onBack: () -> Unit) {
    val scope = rememberCoroutineScope()
    var incidents by remember { mutableStateOf(emptyList<Incident>()) }
    var status by remember { mutableStateOf("") }

    fun loadIncidents() {
        scope.launch {
            try {
                incidents = TechTestClient.api.getIncidents()
                status = "Reportes cargados desde Tech-test"
            } catch (_: Exception) {
                status = "No se pudo conectar con Incidents"
            }
        }
    }

    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Mis reportes", style = MaterialTheme.typography.headlineSmall)
        Button(onClick = ::loadIncidents) { Text("Cargar desde Tech-test") }
        if (status.isNotBlank()) Text(status)
        LazyColumn(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(incidents) { incident -> Card(Modifier.fillMaxWidth()) { Column(Modifier.padding(16.dp)) { Text(incident.description, style = MaterialTheme.typography.titleMedium); Text("Creado: ${incident.createdAt}") } } }
        }
        Button(onClick = onBack) { Text("Volver") }
    }
}
