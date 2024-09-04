package app.cpos.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme

@Composable
actual fun AppTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if(darkTheme) DarkColorScheme else LightColorScheme,
        typography = AppTypography(),
        content = content
    )
}