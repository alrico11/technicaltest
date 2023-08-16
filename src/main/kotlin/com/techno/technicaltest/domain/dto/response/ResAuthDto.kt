package com.techno.technicaltest.domain.dto.response

data class ResAuthDto(
    val accessToken: String? = null,
    val tokenType: String? = null,
    val expiresIn: Long? = null,
)
