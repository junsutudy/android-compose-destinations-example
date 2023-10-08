package app.junsu.checkin.ui.home.room

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.junsu.checkin.data.model.Room
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun RoomListScreen(
    modifier: Modifier = Modifier,
    rooms: List<Room>,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            RoomListTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = "Room List",
            )
        }
    ) { padValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padValues)
                .background(Color.Red),
        ) {
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RoomListTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = title) },
    )
}
