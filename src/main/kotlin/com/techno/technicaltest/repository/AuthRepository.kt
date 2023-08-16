package com.techno.technicaltest.repository
import com.techno.technicaltest.domain.entity.AuthEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AuthRepository : JpaRepository<AuthEntity, String> {
}