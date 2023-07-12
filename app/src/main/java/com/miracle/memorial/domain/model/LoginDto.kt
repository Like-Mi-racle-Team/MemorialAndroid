package com.miracle.memorial.domain.model

data class LoginDto(
    val userId: String,
    val userIntroduce: String?,
    val userName: String,
    val userPassword: String
)