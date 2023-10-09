package app.junsu.checkin.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import app.junsu.checkin.ui.destinations.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckInTopAppBar(
    modifier: Modifier = Modifier,
    destination: Destination,
    navBackStackEntry: NavBackStackEntry?,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = destination.route)
        },
    )
}
