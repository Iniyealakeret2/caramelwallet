package com.hsdesigns.caramelwallet.feature_authentication.data.remote.dto

import com.hsdesigns.caramelwallet.feature_authentication.domain.model.LoginResponse

data class LoginResponseDto(
    val message: String
){
    fun toLoginResponse(): LoginResponse{
        return LoginResponse(
            message = message
        )
    }
}


