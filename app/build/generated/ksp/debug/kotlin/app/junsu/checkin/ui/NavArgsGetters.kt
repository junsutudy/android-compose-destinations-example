package app.junsu.checkin.ui

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavBackStackEntry
import app.junsu.checkin.ui.destinations.RoomDetailsScreenDestination
import app.junsu.checkin.ui.destinations.RoomDetailsScreenDestination.NavArgs

public inline fun <reified T> SavedStateHandle.navArgs(): T {
    return navArgs(T::class.java, this)
}

public inline fun <reified T> NavBackStackEntry.navArgs(): T {
    return navArgs(T::class.java, this)
}

@Suppress("UNCHECKED_CAST")
public fun <T> navArgs(argsClass: Class<T>, argsContainer: SavedStateHandle): T {
    return when (argsClass) {
		NavArgs::class.java -> RoomDetailsScreenDestination.argsFrom(argsContainer) as T
        else -> error("Class ${argsClass} is not a navigation arguments class!")
    }
}

@Suppress("UNCHECKED_CAST")
public fun <T> navArgs(argsClass: Class<T>, argsContainer: NavBackStackEntry): T {
    return when (argsClass) {
		NavArgs::class.java -> RoomDetailsScreenDestination.argsFrom(argsContainer) as T
        else -> error("Class ${argsClass} is not a navigation arguments class!")
    }
}