package hanaoka.hikikomori.uz.server.request

import com.google.gson.annotations.SerializedName

data class SignUpRequst(
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("password")
    val password: String
)