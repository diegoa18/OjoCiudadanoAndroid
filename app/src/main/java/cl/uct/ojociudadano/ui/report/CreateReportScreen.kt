package cl.uct.ojociudadano.ui.report

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.uct.ojociudadano.ui.theme.OjoCiudadanoTheme

@Composable
fun CreateReportScreen(modifier: Modifier = Modifier) {
    Text(text = "Create report", modifier = modifier.fillMaxSize())
}

@Preview(showBackground = true)
@Composable
private fun CreateReportScreenPreview() {
    OjoCiudadanoTheme {
        CreateReportScreen()
    }
}
