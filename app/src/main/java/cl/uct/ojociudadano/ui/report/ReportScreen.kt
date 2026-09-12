package cl.uct.ojociudadano.ui.report

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.uct.ojociudadano.data.remote.CreateIncidentRequest
import cl.uct.ojociudadano.data.remote.TechTestClient
import kotlinx.coroutines.launch

@Composable
fun ReportScreen(
    onBack: () -> Unit
) {
    var description by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Reportar incidente")

        OutlinedTextField(
            value = description,
            onValueChange = { description = it; submitted = false; error = false },
            label = { Text("Descripción") }
        )
        Button(onClick = {
            scope.launch {
                try {
                    TechTestClient.api.createIncident(CreateIncidentRequest(description))
                    submitted = true
                } catch (_: Exception) {
                    error = true
                }
            }
        }, enabled = description.isNotBlank()) {
            Text("Enviar reporte")
        }
        if (submitted) Text("Reporte enviado a Tech-test correctamente")
        if (error) Text("No se pudo conectar con Incidents")

        Button(
            onClick = onBack
        ) {
            Text("Volver")
        }
    }
}
