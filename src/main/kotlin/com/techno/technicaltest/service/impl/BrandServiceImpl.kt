package com.techno.technicaltest.service.impl

import com.techno.technicaltest.domain.dto.request.ReqBrandDto
import com.techno.technicaltest.repository.BrandRepository
import com.techno.technicaltest.domain.dto.response.ResBaseDto
import com.techno.technicaltest.domain.dto.response.ResBrandDto
import com.techno.technicaltest.domain.entity.BrandEntity
import com.techno.technicaltest.exception.CustomExceptionHandler
import com.techno.technicaltest.service.BrandService
import org.springframework.stereotype.Service

@Service
data class BrandServiceImpl(
    private val brandRepository: BrandRepository
) : BrandService {
    override fun getAll(): ResBaseDto<ArrayList<ResBrandDto>> {
        val data: MutableList<BrandEntity> = brandRepository.findAll()
        if (data.isEmpty()) {
            throw CustomExceptionHandler("Data Not Found")
        }
        val res: ArrayList<ResBrandDto> = ArrayList()
        data.forEach {
            res.add(
                ResBrandDto(
                    CD_BRAND = it.CD_BRAND!!,
                    DESC_BRAND = it.DESC_BRAND!!
                )
            )
        }
        return ResBaseDto("T", "Success", res)
    }

    override fun findByDESC_BRAND(descBrand: String): ResBaseDto<out Any> {
        val brandEntities = brandRepository.findAllByDESC_BRAND(descBrand)
        if (brandEntities.isNotEmpty()) {
            val brandEntity = brandEntities.first()
            val resBrandDto = ResBrandDto(
                CD_BRAND = brandEntity.CD_BRAND!!,
                DESC_BRAND = brandEntity.DESC_BRAND!!
            )
            return ResBaseDto("T", "Success", resBrandDto)
        }
        if (descBrand.length <= 10 && descBrand.matches(Regex("^[a-zA-Z0-9]*$"))) {
            return getAll()
        }
        else{
            throw CustomExceptionHandler("Invalid Input")
        }
    }
}
