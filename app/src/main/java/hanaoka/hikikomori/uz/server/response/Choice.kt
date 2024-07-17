package hanaoka.hikikomori.uz.server.response

import com.google.gson.annotations.SerializedName

data class Choice(
    @field:SerializedName("finish_reason")
    val finish_reason: String,
    @field:SerializedName("index")
    val index: Int,
    @field:SerializedName("logprobs")
    val logprobs: Any,
    @field:SerializedName("message")
    val message: MessageX
)