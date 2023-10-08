package app.junsu.checkin.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.junsu.checkin.ui.destinations.RoomDetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
) {
   // navigator.navigate(RoomDetailsScreenDestination)
}
