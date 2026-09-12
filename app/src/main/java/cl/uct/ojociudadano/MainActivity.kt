package cl.uct.ojociudadano

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cl.uct.ojociudadano.navigation.AppNavigation
import cl.uct.ojociudadano.ui.theme.OjoCiudadanoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OjoCiudadanoTheme {
                AppNavigation()
            }
        }
    }
}