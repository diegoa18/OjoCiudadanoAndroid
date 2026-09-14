package cl.uct.ojociudadano.ui.notifications

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.uct.ojociudadano.ui.theme.OjoCiudadanoTheme

@Composable
fun NotificationsScreen(modifier: Modifier = Modifier) {
    Text(text = "Notifications", modifier = modifier.fillMaxSize())
}

@Preview(showBackground = true)
@Composable
private fun NotificationsScreenPreview() {
    OjoCiudadanoTheme {
        NotificationsScreen()
    }
}
