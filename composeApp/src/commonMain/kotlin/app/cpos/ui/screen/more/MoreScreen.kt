package app.cpos.ui.screen.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.cpos.ui.theme.LargeSpacing
import com.voavanga.pos.ui.navigation.NavDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    onSignUpClick: (String) -> Unit
) {
    Scaffold() {
        Column(
            modifier.padding(LargeSpacing)
        ){

            Box(modifier = Modifier.fillMaxSize()
            ) {
                Button(onClick = {onSignUpClick("sign-up")}){
                    Text( text = "Sign Up")
                }
            }
        }

    }

}
