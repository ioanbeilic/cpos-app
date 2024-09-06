package app.cpos.ui.screen.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen(id: String, onBackClick: () -> Unit){
    Scaffold (
    ){

        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "Profile Screen ${id}")
        }

        Button(onClick = {onBackClick()}){
            Text(text = "Back")
        }


    }


}