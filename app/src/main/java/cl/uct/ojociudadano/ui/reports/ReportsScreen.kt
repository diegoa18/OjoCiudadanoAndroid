package cl.uct.ojociudadano.ui.reports

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.uct.ojociudadano.ui.theme.OjoCiudadanoTheme

@Composable
fun ReportsScreen(modifier: Modifier = Modifier) {
    Text(text = "Reports", modifier = modifier.fillMaxSize())
}

@Preview(showBackground = true)
@Composable
private fun ReportsScreenPreview() {
    OjoCiudadanoTheme {
        ReportsScreen()
    }
}
