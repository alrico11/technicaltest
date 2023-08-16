package com.techno.technicaltest.domain.entity

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class AuthEntity(
    @Id
    @field:Column(name = "uuid", columnDefinition = "uuid")
    val id: UUID? = null,

    @field:Column(name= "access_token", columnDefinition = "varchar")
    val accessToken: String? = null,

    @field:Column(name= "token_type", columnDefinition = "varchar")
    val tokenType: String? = null,

    @field:Column(name= "expires_in", columnDefinition = "bigint")
    val expiresIn: Long? = null,

    )
