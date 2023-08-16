package com.techno.technicaltest.config
import com.techno.technicaltest.exception.CustomExceptionHandler
import com.techno.technicaltest.repository.AuthRepository
import com.techno.technicaltest.service.AuthService
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.techno.technicaltest.domain.dto.response.ResBaseDto

@Component
class RequestInterceptor(
    private val authRepository: AuthRepository,
    private val authService: AuthService
):HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        // GRANT TYPE
        if (request.servletPath == "/apiservice/oauth/token") {
            val user = "client_credentials"
            val grantType = request.getParameter("grant_type")
            if (grantType == null || grantType != user) {
                response.status = HttpServletResponse.SC_UNAUTHORIZED
                val result = jacksonObjectMapper().writeValueAsString(ResBaseDto("F", "Invalid_Client", "Unauthorized"))
                response.writer.write(result)
                response.contentType = "application/json"
                response.characterEncoding = "UTF-8"
                return false
            }
            return true
        }
        //API_KEY
        val apiKey = request.getHeader("APIKey")
        val auth = request.getHeader("Authorization")
        if (request.servletPath == "/apiservice/unit/getbrand") {
            if (apiKey != "123-123-123" || auth.isNullOrEmpty() || !auth.startsWith("Bearer ") ) {
                println("GAMASUK SINI")
                throw CustomExceptionHandler("You dont have permission to access the api")
            }
            val token = auth.substring(7)
            if (authService.isTokenValid()) {
                return true
            } else {
                response.status = HttpServletResponse.SC_UNAUTHORIZED
                val result = jacksonObjectMapper().writeValueAsString(ResBaseDto("F", "Signature Not Valid", ""))
                response.writer.write(result)
                response.contentType = "application/json"
                response.characterEncoding = "UTF-8"
                response.status = 403
                return false
            }
            return true
        }
        return true
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {

    }
}