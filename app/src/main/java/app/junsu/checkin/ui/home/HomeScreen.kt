package app.junsu.checkin.ui.home

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import app.junsu.checkin.data.model.Room
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

interface HomeNavigator {
    fun openHome()
    fun openExplore()
    fun openRoomList()
    fun openRoomDetails(room: Room)
    fun openAppInformation(version: Int)
}

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    // navigator: HomeNavigator,
) {
    Scaffold(
        modifier = modifier,
    ) { padValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padValues)
                .background(Color.Blue),
        ) {}
    }
}

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
