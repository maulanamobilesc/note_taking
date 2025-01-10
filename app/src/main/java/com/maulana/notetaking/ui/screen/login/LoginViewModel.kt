package com.maulana.notetaking.ui.screen.login

import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    //private val authRepository: AuthRepository,
    private val dispatcher: CoroutineDispatcher, private val sharedPreferences: SharedPreferences
) : ViewModel(

) {

    var loginMode = mutableStateOf(LoginMode.REGISTER)
    val loginLoading = mutableStateOf(false)
    val loginSuccess = mutableStateOf(false)

    val userName = mutableStateOf("")
    val password = mutableStateOf("")
    val errorMessage = mutableStateOf("")

    /*fun login() {
        viewModelScope.launch(dispatcher) {
            runCatching {
                loginLoading.value = true
                authRepository.login(userName.value, password.value)
            }.onSuccess { response ->
                if (response.token.orEmpty().isNotEmpty()) {
                    sharedPreferences.saveToken(response.token!!)
                    loginLoading.value = false
                    loginSuccess.value = true
                }
            }.onFailure {
                errorMessage.value = it.message.orEmpty()
                loginLoading.value = false
                loginSuccess.value = false
            }
        }
    }*/

}