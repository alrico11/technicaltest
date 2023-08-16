package com.techno.technicaltest.service

import com.techno.technicaltest.domain.dto.request.ReqBrandDto
import com.techno.technicaltest.domain.dto.response.ResBaseDto
import com.techno.technicaltest.domain.dto.response.ResBrandDto

interface BrandService {
    fun getAll(): ResBaseDto<ArrayList<ResBrandDto>>
    fun findByDESC_BRAND(descBrand: String): ResBaseDto<out Any>
}
