package com.techno.technicaltest.service

import com.techno.technicaltest.domain.dto.response.ResBaseDto

interface AuthService {
    fun insert() : ResBaseDto<Any>
    fun isTokenValid(): Boolean
}