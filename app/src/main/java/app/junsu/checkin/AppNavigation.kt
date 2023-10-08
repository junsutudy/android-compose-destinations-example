package app.junsu.checkin

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.junsu.checkin.data.model.Room
import app.junsu.checkin.ui.NavGraphs
import app.junsu.checkin.ui.destinations.HomeDestination
import app.junsu.checkin.ui.home.HomeNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
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
    val navHostEngine = rememberAnimatedNavHostEngine(
        navHostContentAlignment = Alignment.TopCenter,
        rootDefaultAnimations = RootNavGraphDefaultAnimations.ACCOMPANIST_FADING,
        defaultAnimationsForNestedNavGraph = mapOf(),
    )

    DestinationsNavHost(
        modifier = modifier,
        engine = navHostEngine,
        navController = navController,
        navGraph = NavGraphs.root,
    )
}

object NavGraphs {

    val home = object : NavGraphSpec {
        override val startRoute: Route = HomeDestination routedIn this
        override val route: String = "home"
        override val destinationsByRoute: Map<String, DestinationSpec<*>> =
            listOf<DestinationSpec<*>>()
                .routedIn(this)
                .associateBy {
                    it.route
                }
    }
}

class FeatureNavigator(
    private val navGraph: NavGraphSpec,
    private val navController: NavHostController,
) : HomeNavigator {
    override fun openHome() {
        navController.navigate(HomeDestination within navGraph)
    }

    override fun openExplore() {
        // navController.navigate(NavGraphs)
    }

    override fun openRoomList() {
        TODO("Not yet implemented")
    }

    override fun openRoomDetails(room: Room) {
        TODO("Not yet implemented")
    }

    override fun openAppInformation(version: Int) {
        TODO("Not yet implemented")
    }
}
