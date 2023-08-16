package com.techno.technicaltest.repository
import com.techno.technicaltest.domain.dto.request.ReqBrandDto
import com.techno.technicaltest.domain.entity.BrandEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface BrandRepository : JpaRepository<BrandEntity, String> {
    @Transactional
    @Query("SELECT b FROM BrandEntity b WHERE b.DESC_BRAND = :descBrand")
    fun findAllByDESC_BRAND(descBrand: String): List<BrandEntity>
}


