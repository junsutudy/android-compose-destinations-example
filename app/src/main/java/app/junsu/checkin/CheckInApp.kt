package app.junsu.checkin

import androidx.annotation.StringRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import app.junsu.checkin.ui.NavGraphs
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.spec.NavHostEngine

@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
@Composable
fun CheckInApp(
    modifier: Modifier = Modifier,
    navHostEngine: NavHostEngine = rememberAnimatedNavHostEngine(),
    navController: NavHostController = navHostEngine.rememberNavController(),
) {
    val shouldShowBottomAppBar by remember { mutableStateOf(true) }

    Scaffold(
        modifier = modifier,
        topBar = {},
        bottomBar = {
            if (shouldShowBottomAppBar) {
                CheckInBottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    navController = navController,
                )
            }
        },
    ) { padValues ->
        DestinationsNavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(padValues),
            engine = navHostEngine,
            navController = navController,
            navGraph = NavGraphs.root,
            startRoute = NavGraphs.root.startRoute,
        )
    }
}

@Composable
fun CheckInBottomAppBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    BottomAppBar(
        modifier = modifier,
    ) {

    }
}

enum class HomeSections(
    // val direction: ,
    val icon: ImageVector,
    @StringRes val label: Int,
) {
    // EXPLORE(ExploreScreenDestination, )
}

/*
object NavGraphs {

    val home = object : NavGraphSpec {
        override val startRoute: Route = HomeDestination routedIn this
        override val route: String = "home"
        override val destinationsByRoute: Map<String, DestinationSpec<*>> =
            listOf<DestinationSpec<*>>(
                HomeDestination,
                ExploreScreenDestination,
                RoomListScreenDestination,
            )
                .routedIn(this)
                .associateBy { it.route }
    }

    val root = object : NavGraphSpec {
        override val route: String = "root"
        override val startRoute: Route = home
        override val destinationsByRoute: Map<String, DestinationSpec<*>> = emptyMap()
        override val nestedNavGraphs: List<NavGraphSpec> = listOf(
            home,
        )
    }
}*//*

class FeatureNavigator(
    private val navGraph: NavGraphSpec,
    private val navController: NavHostController,
) : HomeNavigator {
    override fun openHome() {
        navController.navigate(HomeDestination within navGraph)
    }

    override fun openExplore() {
        navController.navigate(ExploreScreenDestination within navGraph)
    }

    override fun openRoomList() {
        navController.navigate(RoomListScreenDestination within navGraph)
    }

    override fun openRoomDetails(room: Room) {
        navController.navigate(RoomDetailsScreenDestination within navGraph)
    }

    override fun openAppInformation(version: Int) {
        navController.navigate(AppInformationScreenDestination within navGraph)
    }
}
*/