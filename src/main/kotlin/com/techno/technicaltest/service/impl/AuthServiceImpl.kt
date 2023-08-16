package com.techno.technicaltest.service.impl

import com.techno.technicaltest.domain.dto.response.ResAuthDto
import com.techno.technicaltest.domain.dto.response.ResBaseDto
import com.techno.technicaltest.domain.entity.AuthEntity
import com.techno.technicaltest.repository.AuthRepository
import com.techno.technicaltest.service.AuthService
import com.techno.technicaltest.util.JWTGenerator
import org.springframework.stereotype.Service
import java.util.UUID

@Service
data class AuthServiceImpl(
    private val authRepository: AuthRepository,
    private var token: String? = null,
    private var lastGeneratedTime: Long = 0
): AuthService{
    override fun insert(): ResBaseDto<Any> {
        val exp = 3600000L
        val currentTime = System.currentTimeMillis()
        if (token == null || currentTime - lastGeneratedTime >= 5000) {
            token = JWTGenerator().createJWT(exp)
            lastGeneratedTime = currentTime
        }
        val res = ResAuthDto(
            tokenType = "Bearer",
            expiresIn = 5000,
            accessToken = token,
        )
        val uuid = UUID.randomUUID()
        val data = AuthEntity(
            id = uuid,
            tokenType = "Bearer",
            expiresIn = 5000,
            accessToken = token
        )
        val entity = authRepository.save(data)
        return ResBaseDto(OUT_DATA = res)
    }
    override fun isTokenValid(): Boolean {
        val currentTime = System.currentTimeMillis()
        val expirationTime = lastGeneratedTime + 100000
        return token != null && currentTime < expirationTime
    }
}