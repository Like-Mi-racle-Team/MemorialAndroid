package com.miracle.memorial.domain.repository

import com.miracle.memorial.domain.model.Login
import com.miracle.memorial.domain.model.LoginDto
import com.miracle.memorial.domain.model.RefreshToken
import com.miracle.memorial.domain.model.Token
import com.miracle.memorial.domain.model.TokenDto

interface LoginRepository {

    suspend fun login(
        loginDto: LoginDto
    ): Login

    suspend fun refreshToken(
    ): RefreshToken

    suspend fun token(
        tokenDto: TokenDto
    ): Token

}