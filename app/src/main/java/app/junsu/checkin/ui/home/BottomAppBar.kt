package app.junsu.checkin.ui.home

import androidx.annotation.StringRes
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController

@Composable
fun HomeBottomAppBar(
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
