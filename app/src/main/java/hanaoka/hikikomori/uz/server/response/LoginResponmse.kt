package hanaoka.hikikomori.uz.server.response

import com.google.gson.annotations.SerializedName

data class LoginResponmse(
    @field:SerializedName("accessToken")
    val accessToken: String,
    @field:SerializedName("refreshToken")
    val refreshToken: String
)