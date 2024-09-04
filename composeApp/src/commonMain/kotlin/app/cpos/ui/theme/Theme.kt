package app.cpos.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val AppShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(12.dp)
)

// Dark Theme Scheme
val DarkColorScheme = darkColorScheme(
    primary = BluePrimaryDark,
    secondary = BlueSecondaryDark,
    tertiary = BlueTertiaryDark,
    onPrimary = OnBlueDark,
    primaryContainer = BlueContainerDark,
    onPrimaryContainer = OnBlueContainerDark,
    onSecondary = OnBlueSecondaryDark,
    secondaryContainer = BlueSecondaryContainerDark,
    onSecondaryContainer = OnBlueSecondaryContainerDark,
    onTertiary = OnBlueTertiaryDark,
    onTertiaryContainer = OnBlueTertiaryContainerDark,
    tertiaryContainer = BlueTertiaryContainerDark,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = OnSurfaceVariantDark,
    error = ErrorDark,
    onError = OnErrorDark,
    errorContainer = ErrorContainerDark,
    onErrorContainer = OnErrorContainerDark,
    outline = OutlineDark,
)

// Light Theme Scheme
val LightColorScheme = lightColorScheme(
    primary = BluePrimaryLight,
    secondary = BlueSecondaryLight,
    tertiary = BlueTertiaryLight,
    onPrimary = OnBlueLight,
    primaryContainer = BlueContainerLight,
    onPrimaryContainer = OnBlueContainerLight,
    onSecondary = OnBlueSecondaryLight,
    secondaryContainer = BlueSecondaryContainerLight,
    onSecondaryContainer = OnBlueSecondaryContainerLight,
    onTertiary = OnBlueTertiaryLight,
    onTertiaryContainer = OnBlueTertiaryContainerLight,
    tertiaryContainer = BlueTertiaryContainerLight,
    background = BackgroundLight,
    onBackground = OnBackgroundLight,
    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = OnSurfaceVariantLight,
    error = ErrorLight,
    onError = OnErrorLight,
    errorContainer = ErrorContainerLight,
    onErrorContainer = OnErrorContainerLight,
    outline = OutlineLight,
)

@Composable
expect fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean,
    content: @Composable () -> Unit
)

