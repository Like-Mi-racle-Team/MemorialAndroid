package com.miracle.memorial.data.remote.request.login

data class JoinRequest(
    val userId: String,
    val userIntroduce: String?,
    val userName: String,
    val userPassword: String
)