package hanaoka.hikikomori.uz.server.service

import hanaoka.hikikomori.uz.server.request.LoginRequest
import hanaoka.hikikomori.uz.server.request.SignUpRequst
import hanaoka.hikikomori.uz.server.response.LoginResponmse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("/user/signup")
    suspend fun signUp(
        @Body body : SignUpRequst
    ): String

    @POST("/user/login")
    suspend fun login(
        @Body requestBody : LoginRequest
    ): LoginResponmse
}