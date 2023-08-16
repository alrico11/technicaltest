package com.techno.technicaltest.domain.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class BrandEntity(
    @Id
    @field:Column(name = "uuid", columnDefinition = "uuid")
    val id: UUID? = null,
    @field:Column(name = "cd_brand", columnDefinition = "varchar")
    val CD_BRAND : String? = null,
    @field:Column(name = "desc_brand", columnDefinition = "varchar")
    val DESC_BRAND : String? = null
)
