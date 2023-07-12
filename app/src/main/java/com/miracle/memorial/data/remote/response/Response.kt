package com.miracle.memorial.data.remote.response

data class Response<T>(
    val status: Int,
    val message: String,
    val data: T
)