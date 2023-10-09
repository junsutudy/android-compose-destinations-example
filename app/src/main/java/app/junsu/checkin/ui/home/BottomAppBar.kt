package app.junsu.checkin.ui.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import app.junsu.checkin.R
import app.junsu.checkin.ui.destinations.DirectionDestination
import app.junsu.checkin.ui.destinations.ExploreScreenDestination
import app.junsu.checkin.ui.destinations.RoomListScreenDestination

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
}
