package app.junsu.checkin.ui.home.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.junsu.checkin.ui.home.HomeNavGraph
import com.ramcosta.composedestinations.annotation.Destination

@Destination(
    navGraph = HomeNavGraph.route,
)
@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ExploreTopAppBar(
                modifier = Modifier.fillMaxSize(),
                title = "Explore",
            )
        }
    ) { padValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padValues)
                .background(Color.Blue),
        ) {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ExploreTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = title) },
    )
}
