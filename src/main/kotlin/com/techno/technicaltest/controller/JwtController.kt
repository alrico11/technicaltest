package com.techno.technicaltest.controller

import com.techno.technicaltest.domain.dto.response.ResAuthDto
import com.techno.technicaltest.domain.dto.response.ResBaseDto
import com.techno.technicaltest.service.AuthService
import com.techno.technicaltest.util.JWTGenerator
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController

@RequestMapping("/apiservice/oauth")

private class JwtController (
    private val authService: AuthService
){
    @PostMapping("/token")
    fun insert(): ResponseEntity<ResBaseDto<Any>> {
        val res = authService.insert()
        return ResponseEntity.ok().body(res)
    }
}