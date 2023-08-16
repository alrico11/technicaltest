package com.techno.technicaltest.controller

import com.techno.technicaltest.domain.dto.request.ReqBrandDto
import com.techno.technicaltest.domain.dto.response.ResBaseDto
import com.techno.technicaltest.domain.dto.response.ResBrandDto
import com.techno.technicaltest.service.BrandService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/apiservice/unit")
class BrandController(
    private val brandService: BrandService
) {
    @GetMapping("/getbrand")
    fun getAll(): ResponseEntity<ResBaseDto<ArrayList<ResBrandDto>>> {
        val response = brandService.getAll()
        return ResponseEntity.ok().body(response)
    }
    @PostMapping("/getbrand")
    fun findByDESC_BRAND(@Valid @RequestBody reqBrandDto: ReqBrandDto): ResponseEntity<out ResBaseDto<out Any>> {
        val response = brandService.findByDESC_BRAND(reqBrandDto.filterUnitBrand.descBrand)
        return ResponseEntity.ok().body(response)
    }
}