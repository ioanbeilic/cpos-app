
package app.cpos.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font

import androidx.compose.material3.Typography
import cpos.composeapp.generated.resources.*
import cpos.composeapp.generated.resources.Res

@Composable
fun LatoFontFamily() = FontFamily(
    Font(Res.font.lato_light, weight = FontWeight.Light),
    Font(Res.font.lato_regular, weight = FontWeight.Normal),
    Font(Res.font.lato_black, weight = FontWeight.Medium),
    Font(Res.font.lato_black, weight = FontWeight.SemiBold),
    Font(Res.font.lato_bold, weight = FontWeight.Bold)
)

@Composable
fun AppTypography() = Typography().run {

    val fontFamily = LatoFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily =  fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}
