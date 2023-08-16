package com.techno.technicaltest.domain.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class ReqBrandDto(
    @JsonProperty("getListFilterUnitBrand")
    val filterUnitBrand: FilterUnitBrandDto
)

data class FilterUnitBrandDto(
    @JsonProperty("descBrand")
    @field:Size(max = 10, message = "Invalid input: Maximum length is 10")
    @field:Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid input: Only alphanumeric characters are allowed")
    val descBrand: String
)