package com.hsdesigns.caramelwallet.feature_authentication.domain.model

data class LoginRequest(
    val email: String,
    val password: String
)
