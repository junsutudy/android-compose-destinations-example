package app.junsu.checkin.ui.destinations

import android.os.Bundle
import androidx.annotation.RestrictTo
import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument
import app.junsu.checkin.ui.room.RoomDetailsScreen
import com.ramcosta.composedestinations.navargs.primitives.DestinationsBooleanNavType
import com.ramcosta.composedestinations.navargs.primitives.DestinationsIntNavType
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavType
import com.ramcosta.composedestinations.scope.DestinationScope
import com.ramcosta.composedestinations.spec.Direction

public object RoomDetailsScreenDestination : TypedDestination<RoomDetailsScreenDestination.NavArgs> {
    
    override fun invoke(navArgs: NavArgs): Direction = with(navArgs) {
        invoke(roomNumber, roomName, using)
    }
     
    public operator fun invoke(
		roomNumber: Int,
		roomName: String,
		using: Boolean,
    ): Direction {
        return Direction(
            route = "$baseRoute" + 
					"/${DestinationsIntNavType.serializeValue(roomNumber)}" + 
					"/${DestinationsStringNavType.serializeValue("roomName", roomName)}" + 
					"/${DestinationsBooleanNavType.serializeValue(using)}"
        )
    }
    
    @get:RestrictTo(RestrictTo.Scope.SUBCLASSES)
    override val baseRoute: String = "room_details_screen"

    override val route: String = "$baseRoute/{roomNumber}/{roomName}/{using}"
    
	override val arguments: List<NamedNavArgument> get() = listOf(
		navArgument("roomNumber") {
			type = DestinationsIntNavType
		},
		navArgument("roomName") {
			type = DestinationsStringNavType
		},
		navArgument("using") {
			type = DestinationsBooleanNavType
		}
	)

    @Composable
    override fun DestinationScope<NavArgs>.Content() {
		val (roomNumber, roomName, using) = navArgs
		RoomDetailsScreen(
			roomNumber = roomNumber, 
			roomName = roomName, 
			using = using
		)
    }
                    
	override fun argsFrom(bundle: Bundle?): NavArgs {
	    return NavArgs(
			roomNumber = DestinationsIntNavType.safeGet(bundle, "roomNumber") ?: throw RuntimeException("'roomNumber' argument is mandatory, but was not present!"),
			roomName = DestinationsStringNavType.safeGet(bundle, "roomName") ?: throw RuntimeException("'roomName' argument is mandatory, but was not present!"),
			using = DestinationsBooleanNavType.safeGet(bundle, "using") ?: throw RuntimeException("'using' argument is mandatory, but was not present!"),
	    )
	}
                
	override fun argsFrom(savedStateHandle: SavedStateHandle): NavArgs {
	    return NavArgs(
			roomNumber = DestinationsIntNavType.get(savedStateHandle, "roomNumber") ?: throw RuntimeException("'roomNumber' argument is mandatory, but was not present!"),
			roomName = DestinationsStringNavType.get(savedStateHandle, "roomName") ?: throw RuntimeException("'roomName' argument is mandatory, but was not present!"),
			using = DestinationsBooleanNavType.get(savedStateHandle, "using") ?: throw RuntimeException("'using' argument is mandatory, but was not present!"),
	    )
	}

	public data class NavArgs(
		val roomNumber: Int,
		val roomName: String,
		val using: Boolean,
	)
}