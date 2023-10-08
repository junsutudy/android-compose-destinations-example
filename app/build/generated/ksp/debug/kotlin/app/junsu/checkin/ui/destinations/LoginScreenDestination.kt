package app.junsu.checkin.ui.destinations

import androidx.annotation.RestrictTo
import androidx.compose.runtime.Composable
import app.junsu.checkin.ui.login.LoginScreen
import com.ramcosta.composedestinations.scope.DestinationScope
import com.ramcosta.composedestinations.spec.Direction

public object LoginScreenDestination : DirectionDestination {
         
    public operator fun invoke(): Direction = this
    
    @get:RestrictTo(RestrictTo.Scope.SUBCLASSES)
    override val baseRoute: String = "login_screen"

    override val route: String = baseRoute
    
    @Composable
    override fun DestinationScope<Unit>.Content() {
		LoginScreen()
    }
    
}