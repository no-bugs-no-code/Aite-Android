package hanaoka.hikikomori.uz.server.response

import com.google.gson.annotations.SerializedName

data class ChatGptRequset(
    @field:SerializedName("messages")
    val messages: List<Message>,
    @field:SerializedName("model")
    val model: String,
    @field:SerializedName("temperature")
    val temperature: Double
)