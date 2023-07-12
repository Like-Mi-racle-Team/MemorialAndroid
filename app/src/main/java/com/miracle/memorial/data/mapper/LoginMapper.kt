package com.miracle.memorial.data.mapper

import com.miracle.memorial.data.remote.request.login.LoginRequest
import com.miracle.memorial.data.remote.response.login.LoginResponse
import com.miracle.memorial.domain.model.Login
import com.miracle.memorial.domain.model.LoginDto

fun LoginDto.toModel(): LoginRequest = LoginRequest(
    userId = this.userId,
    userIntroduce = this.userIntroduce,
    userName = this.userName,
    userPassword = this.userPassword
)

//fun TokenDto.toModel(): TokenRequest = TokenRequest(
//    authCode = this.authCode
//)

//fun TokenResponse.toEntity(): Token = Token(
//    accessToken = this.accessToken,
//    refreshToken = this.refreshToken
//)
//
//fun RefreshTokenResponse.toEntity(): RefreshToken = RefreshToken(
//    accessToken = this.accessToken
//)

fun LoginResponse.toEntity(): Login = Login(
    authCode = this.authCode
)