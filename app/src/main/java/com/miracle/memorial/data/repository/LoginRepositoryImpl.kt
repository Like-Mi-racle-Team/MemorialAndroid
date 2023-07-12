package com.miracle.memorial.data.repository

import com.miracle.memorial.data.mapper.toEntity
import com.miracle.memorial.data.mapper.toModel
import com.miracle.memorial.data.remote.api.LoginApi
import com.miracle.memorial.domain.model.Login
import com.miracle.memorial.domain.model.LoginDto
import com.miracle.memorial.domain.model.RefreshToken
import com.miracle.memorial.domain.model.Token
import com.miracle.memorial.domain.model.TokenDto
import com.miracle.memorial.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginApi: LoginApi
) : LoginRepository {
    override suspend fun login(loginDto: LoginDto): Login =
         loginApi.login(loginDto.toModel()).data.toEntity()

    override suspend fun refreshToken(): RefreshToken {
        TODO("Not yet implemented")
    }

    override suspend fun token(tokenDto: TokenDto): Token {
        TODO("Not yet implemented")
    }

}