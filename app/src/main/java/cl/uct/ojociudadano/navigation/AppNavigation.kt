package cl.uct.ojociudadano.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.uct.ojociudadano.ui.home.HomeScreen
import cl.uct.ojociudadano.ui.notifications.NotificationsScreen
import cl.uct.ojociudadano.ui.report.CreateReportScreen
import cl.uct.ojociudadano.ui.reports.ReportsScreen

object AppRoutes {
    const val HOME = "home"
    const val REPORTS = "reports"
    const val CREATE_REPORT = "create_report"
    const val NOTIFICATIONS = "notifications"
}

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = AppRoutes.HOME) {
        composable(AppRoutes.HOME) {
            HomeScreen(
                onReportsClick = { navController.navigate(AppRoutes.REPORTS) },
                onCreateReportClick = { navController.navigate(AppRoutes.CREATE_REPORT) },
                onNotificationsClick = { navController.navigate(AppRoutes.NOTIFICATIONS) }
            )
        }
        composable(AppRoutes.REPORTS) {
            ReportsScreen(onBack = navController::navigateUp)
        }
        composable(AppRoutes.CREATE_REPORT) {
            CreateReportScreen(onBack = navController::navigateUp)
        }
        composable(AppRoutes.NOTIFICATIONS) {
            NotificationsScreen(onBack = navController::navigateUp)
        }
    }
}
