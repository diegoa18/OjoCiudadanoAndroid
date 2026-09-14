package cl.uct.ojociudadano.ui.reports

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.uct.ojociudadano.ui.theme.OjoCiudadanoTheme

@Composable
fun ReportsScreen(modifier: Modifier = Modifier, onBack: () -> Unit = {}) {
    SectionScreen(
        modifier = modifier,
        title = "Mis reportes",
        message = "Aquí podrás revisar el estado de los reportes que has realizado.",
        onBack = onBack
    )
}

@Preview(showBackground = true)
@Composable
private fun ReportsScreenPreview() {
    OjoCiudadanoTheme {
        ReportsScreen()
    }
}

@Composable
private fun SectionScreen(modifier: Modifier, title: String, message: String, onBack: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Text(
                text = message,
                modifier = Modifier.padding(20.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onBack) {
            Text("Volver")
        }
    }
}
