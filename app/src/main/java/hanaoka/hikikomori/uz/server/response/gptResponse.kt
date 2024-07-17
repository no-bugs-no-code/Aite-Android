package hanaoka.hikikomori.uz.server.response

import com.google.gson.annotations.SerializedName

data class gptResponse(
    @field:SerializedName("choices")
    val choices: List<Choice>,
    @field:SerializedName("created")
    val created: Int,
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("model")
    val model: String,
    @field:SerializedName("object")
    val `object`: String,
    @field:SerializedName("system_fingerprint")
    val system_fingerprint: Any,
    @field:SerializedName("usage")
    val usage: Usage
)