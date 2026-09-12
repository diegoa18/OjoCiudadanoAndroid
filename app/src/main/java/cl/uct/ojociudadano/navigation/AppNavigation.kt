package cl.uct.ojociudadano.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.uct.ojociudadano.ui.home.HomeScreen
import cl.uct.ojociudadano.ui.notifications.NotificationsScreen
import cl.uct.ojociudadano.ui.report.ReportScreen
import cl.uct.ojociudadano.ui.reports.MyReportsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onReportClick = { navController.navigate("report") },
                onReportsClick = { navController.navigate("reports") },
                onNotificationsClick = { navController.navigate("notifications") }
            )
        }
        composable("report") { ReportScreen(onBack = { navController.popBackStack() }) }
        composable("reports") { MyReportsScreen(onBack = { navController.popBackStack() }) }
        composable("notifications") { NotificationsScreen(onBack = { navController.popBackStack() }) }
    }
}
