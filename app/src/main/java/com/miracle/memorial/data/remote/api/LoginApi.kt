package com.miracle.memorial.data.remote.api

import com.miracle.memorial.data.remote.request.login.JoinRequest
import com.miracle.memorial.data.remote.request.login.LoginRequest
import com.miracle.memorial.data.remote.response.Response
import com.miracle.memorial.data.remote.response.login.LoginResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface LoginApi {

    @POST("auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @POST("auth/join")
    suspend fun join(
        @Body joinRequest: JoinRequest
    ): Response<Unit>
}