package app.junsu.checkin.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        bottomBar = {

        },
    ) { padValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padValues)
                .background(Color.Blue),
        ) {}
    }
}
