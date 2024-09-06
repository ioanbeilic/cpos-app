package app.cpos.ui.screen.auth.signUp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import app.cpos.ui.components.CustomTextField
import app.cpos.ui.theme.*
import cpos.composeapp.generated.resources.*
import cpos.composeapp.generated.resources.Res
import cpos.composeapp.generated.resources.email
import cpos.composeapp.generated.resources.password
import cpos.composeapp.generated.resources.user_name
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    uiState: SignUpUIState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                top = ExtraLargeSpacing,
                start = ExtraLargeSpacing,
                end = ExtraLargeSpacing,
                bottom = ExtraLargeSpacing
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            LargeSpacing
        )


    ) {
        CustomTextField(
            value = uiState.name,
            onValueChange = onNameChange ,
            hint = stringResource(Res.string.user_name)
        )

        CustomTextField(
            value = uiState.email,
            onValueChange = onEmailChange ,
            hint = stringResource(Res.string.email),
            keyboardType = KeyboardType.Email
        )

        CustomTextField(
            value = uiState.email,
            onValueChange = onPasswordChange ,
            hint = stringResource(Res.string.password),
            isPassword = true,
            keyboardType = KeyboardType.Password
        )

        Button(
            onClick = {
            },
            modifier = modifier
                .fillMaxWidth()
                .height(ButtonHeight),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 0.dp
            ),
            shape = MaterialTheme.shapes.medium
        ){
            Text(
                text = stringResource(Res.string.sign_up)
            )

        }

    }
}


@Preview
@Composable
fun SignUpScreenPreview(){
    AppTheme(
        darkTheme = false,
        dynamicColor = false
    ){
        SignUpScreen(
          uiState =   SignUpUIState(
                name = "",
                email = "",
                password = ""
            ),
            onEmailChange = {},
            onPasswordChange = {},
            onNameChange = {}


        )
    }
}