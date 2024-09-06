package app.cpos.ui.screen.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NotificationScreen(onNotificationClick: (String) -> Unit){
    Scaffold (){
        Box(modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
        ) {
            Text(text = "Notification Screen")

            Button(onClick = {onNotificationClick("profile/1")}){

            }
        }
    }
}