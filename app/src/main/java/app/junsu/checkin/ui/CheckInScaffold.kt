package app.junsu.checkin.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.plusAssign
import app.junsu.checkin.ui.destinations.Destination
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.spec.Route

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun CheckInScaffold(
    modifier: Modifier = Modifier,
    startRoute: Route,
    navController: NavHostController,
    topAppBar: @Composable (Destination) -> Unit,
    bottomAppBar: @Composable (Destination) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    val destination = navController.appCurrentDestinationAsState().value
        ?: startRoute.startAppDestination
    val navBackStackEntry = navController.currentBackStackEntry

    val bottomSheetNavigator = rememberBottomSheetNavigator()
    navController.navigatorProvider += bottomSheetNavigator
    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = RoundedCornerShape(16.dp)
    ) {
        Scaffold(
            topBar = { topAppBar(destination) },
            bottomBar = { bottomAppBar(destination) },
            content = content
        )
    }
}
