package app.cpos.ui.screen.auth.signUp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class SignUpViewModel: ViewModel() {
    var uiState by mutableStateOf(SignUpUIState())
        private set

    fun updateEmail(email: String){
        uiState = uiState.copy(email = email)
    }

    fun updatePassword(password: String){
        uiState = uiState.copy(password = password)
    }

    fun updateName(name: String){
        uiState = uiState.copy(name = name)
    }

}

data class SignUpUIState(
    var email: String = "",
    var password: String = "",
    var name: String = ""
)