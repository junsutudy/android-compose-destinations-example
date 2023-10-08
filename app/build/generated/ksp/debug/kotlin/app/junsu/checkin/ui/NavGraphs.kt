package app.junsu.checkin.ui

import app.junsu.checkin.ui.destinations.*
import com.ramcosta.composedestinations.spec.*

/**
 * Class generated if any Composable is annotated with `@Destination`.
 * It aggregates all [TypedDestination]s in their [NavGraph]s.
 */
public object NavGraphs {

    public val root: NavGraph = NavGraph(
        route = "root",
        startRoute = HomeDestination,
        destinations = listOf(
            HomeDestination,
			ExploreScreenDestination,
			RoomDetailsScreenDestination,
			RoomListScreenDestination,
			LoginScreenDestination
        )
    )
}