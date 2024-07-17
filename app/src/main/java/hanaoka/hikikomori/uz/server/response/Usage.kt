package hanaoka.hikikomori.uz.server.response

import com.google.gson.annotations.SerializedName

data class Usage(
    @field:SerializedName("completion_tokens")
    val completion_tokens: Int,
    @field:SerializedName("prompt_tokens")
    val prompt_tokens: Int,
    @field:SerializedName("total_tokens")
    val total_tokens: Int
)