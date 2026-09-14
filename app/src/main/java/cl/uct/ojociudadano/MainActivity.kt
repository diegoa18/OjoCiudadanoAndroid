package cl.uct.ojociudadano

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cl.uct.ojociudadano.navigation.AppNavigation
import cl.uct.ojociudadano.ui.theme.OjoCiudadanoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OjoCiudadanoTheme {
                AppNavigation()
            }
        }
    }
}
