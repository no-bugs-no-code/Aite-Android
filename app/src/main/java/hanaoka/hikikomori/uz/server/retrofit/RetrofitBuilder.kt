package hanaoka.hikikomori.uz.server.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import hanaoka.hikikomori.uz.server.service.GptService
import hanaoka.hikikomori.uz.server.service.LoginService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder {
    companion object{
        private var gson: Gson? = null
        private var retrofit: Retrofit? = null
        private var gptService: GptService? = null
        private var loginService: LoginService? = null


        @Synchronized
        fun getGson(): Gson? {
            if (gson == null) {
                gson = GsonBuilder().setLenient().create()
            }

            return gson
        }

        @Synchronized
        fun getRetrofit(): Retrofit {
            if (retrofit == null) {

                val client = OkHttpClient.Builder()
                    .connectTimeout(50, TimeUnit.SECONDS)
                    .readTimeout(50,TimeUnit.SECONDS)
                    .writeTimeout(50,TimeUnit.SECONDS)
                    .build()
                retrofit = Retrofit.Builder()
                    .baseUrl(Url.serverUrl)
                    .addConverterFactory(GsonConverterFactory.create(getGson()!!))
                    .client(client)
                    .build()
            }
            return retrofit!!
        }

        fun getGptService(): GptService{
            if (gptService == null){
                gptService = getRetrofit().create(GptService::class.java)
            }
            return gptService!!
        }
        fun getLoginService(): LoginService{
            if (loginService == null){
                loginService = getRetrofit().create(LoginService::class.java)
            }
            return loginService!!
        }
    }
}