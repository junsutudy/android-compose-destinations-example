package app.junsu.checkin

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.junsu.checkin.data.model.Room
import app.junsu.checkin.ui.NavGraphs
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.dynamic.within
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navHostEngine = rememberAnimatedNavHostEngine()

    DestinationsNavHost(
        modifier = modifier,
        engine = navHostEngine,
        navController = navController,
        navGraph = NavGraphs.root,
        startRoute = NavGraphs.root.startRoute,
    )
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
}*/
/*

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
