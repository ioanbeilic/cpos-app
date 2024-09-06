package app.cpos.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import app.cpos.ui.theme.AppTheme
import cpos.composeapp.generated.resources.Res
import cpos.composeapp.generated.resources.hide_password
import cpos.composeapp.generated.resources.show_password
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun  CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false,
    isSingleLine: Boolean = true,
    hint: String = ""
) {

    var isPasswordVisible by remember { mutableStateOf(false) }


    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.bodyMedium,
        shape = MaterialTheme.shapes.medium,
        placeholder = {
            Text(text = hint, style = MaterialTheme.typography.bodyMedium)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType
        ),
        singleLine = isSingleLine,
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        ),
        trailingIcon =  if (isPassword) {
            {
                PasswordEysIcon(
                    isPasswordVisible = isPasswordVisible,
                ) {
                    isPasswordVisible = !isPasswordVisible
                }
            }
        } else null,
        visualTransformation = if (isPassword) {
            if (isPasswordVisible) VisualTransformation.None
            else PasswordVisualTransformation()
        } else VisualTransformation.None
    )

}

@Composable
fun PasswordEysIcon(
    isPasswordVisible: Boolean,
    onPasswordVisibilityToggle: () -> Unit,
){
    val image = if (isPasswordVisible)  Icons.Filled.Visibility else Icons.Filled.VisibilityOff
    val contentDescription = if (isPasswordVisible) Res.string.hide_password  else Res.string.show_password

    IconButton(onClick = onPasswordVisibilityToggle) {
        Icon(imageVector = image, contentDescription = stringResource(contentDescription))
    }

}


@Preview
@Composable
fun CustomTextFieldPreview() {
    AppTheme(
        darkTheme = true,
        dynamicColor = false
    ){
        CustomTextField(
            value = "",
            onValueChange = {},
            hint = "Password",
            isPassword = true
        )
    }
}