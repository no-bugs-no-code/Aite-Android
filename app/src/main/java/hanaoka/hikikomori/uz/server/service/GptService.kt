package hanaoka.hikikomori.uz.server.service

import hanaoka.hikikomori.uz.server.response.ChatGptRequset
import hanaoka.hikikomori.uz.server.response.gptResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface GptService {
    @POST("/api/v1/chatGpt/prompt")
    suspend fun getGpt(
        @Body body : ChatGptRequset
    ):gptResponse
    @POST("/file/upload")
    suspend fun uploadImage(
        @Body body: String
    ) : String
}
//192.168.0.24