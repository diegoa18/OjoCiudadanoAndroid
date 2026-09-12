package cl.uct.ojociudadano.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val colors = lightColorScheme(primary = Purple40, secondary = PurpleGrey40, tertiary = Pink40)

@Composable
fun OjoCiudadanoTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = colors, typography = Typography, content = content)
}
