package hanaoka.hikikomori.uz.server.response

import com.google.gson.annotations.SerializedName

data class Message(
    @field:SerializedName("content")
    val content: String,
    @field:SerializedName("role")
    val role: String
)