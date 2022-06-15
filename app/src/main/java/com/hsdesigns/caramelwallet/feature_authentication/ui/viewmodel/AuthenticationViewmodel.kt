package com.hsdesigns.caramelwallet.feature_authentication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hsdesigns.caramelwallet.common.utils.Resource
import com.hsdesigns.caramelwallet.feature_authentication.domain.model.LoginRequest
import com.hsdesigns.caramelwallet.feature_authentication.domain.model.LoginResponse
import com.hsdesigns.caramelwallet.feature_authentication.domain.useCases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewmodel @Inject constructor(
    val loginUseCase: LoginUseCase
): ViewModel() {
    private var _loginState = MutableLiveData<Resource<List<LoginResponse>>>()
    val loginState: LiveData<Resource<List<LoginResponse>>> get() = _loginState

    fun userLogin(loginRequest: LoginRequest){
        viewModelScope.launch {
            loginUseCase(loginRequest).collect {
                _loginState.value = it
            }
        }
    }
}