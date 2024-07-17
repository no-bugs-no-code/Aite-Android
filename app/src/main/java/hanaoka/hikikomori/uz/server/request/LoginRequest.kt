package hanaoka.hikikomori.uz.server.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("password")
    val password: String
)