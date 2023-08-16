package com.techno.technicaltest.domain.dto.response

data class ResBaseDto <T>(

    val OUT_STAT : String = "T",
    val OUT_MESS : String = "Success",
    val OUT_DATA : T? = null,
)
