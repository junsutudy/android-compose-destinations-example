package app.junsu.checkin.ui.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import app.junsu.checkin.R
import app.junsu.checkin.ui.NavGraphs
import app.junsu.checkin.ui.destinations.DirectionDestination
import app.junsu.checkin.ui.destinations.ExploreScreenDestination
import app.junsu.checkin.ui.destinations.RoomListScreenDestination
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popBackStack
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.utils.isRouteOnBackStack

class BottomAppBarIcons(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

@Composable
fun CheckInBottomAppBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    BottomAppBar(
        modifier = modifier,
    ) {
        CheckInSections.entries.forEach { (direction, icon, label) ->
            val selected = navController.isRouteOnBackStack(direction)

            NavigationBarItem(
                selected = selected,
                onClick = {
                    println("SELECTEDSELECTED ${direction.route} $selected" +
                            "\n${navController.graph}")
                    if (selected) {
                        navController.popBackStack(
                            route = direction,
                            inclusive = false,
                        )
                        return@NavigationBarItem
                    }

                    navController.navigate(direction) {
                        popUpTo(NavGraphs.root) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (selected) {
                            icon.selectedIcon
                        } else {
                            icon.unselectedIcon
                        },
                        contentDescription = stringResource(id = label),
                    )
                },
            )
        }
    }
}

enum class CheckInSections(
    val direction: DirectionDestination,
    val icon: BottomAppBarIcons,
    @StringRes val label: Int,
) {
    EXPLORE(
        direction = ExploreScreenDestination,
        icon = BottomAppBarIcons(
            selectedIcon = Icons.Filled.LocationOn,
            unselectedIcon = Icons.Outlined.LocationOn,
        ),
        label = R.string.bottom_app_bar_section_explore,
    ),
    ROOM_LIST(
        direction = RoomListScreenDestination,
        icon = BottomAppBarIcons(
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search,
        ),
        label = R.string.bottom_app_bar_section_room_list,
    ),
    ;

    operator fun component1() = direction
    operator fun component2() = icon
    operator fun component3() = label
}
