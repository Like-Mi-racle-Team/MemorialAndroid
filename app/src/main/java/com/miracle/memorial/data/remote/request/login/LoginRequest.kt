package com.miracle.memorial.data.remote.request.login

import retrofit2.http.Field

data class LoginRequest(
    val userId: String,
    val userIntroduce: String?,
    val userName: String?,
    val userPassword: String
)