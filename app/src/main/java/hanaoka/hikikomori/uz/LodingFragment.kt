package hanaoka.hikikomori.uz

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.google.gson.JsonObject
import hanaoka.hikikomori.uz.databinding.FragmentLodingBinding
import hanaoka.hikikomori.uz.server.response.ChatGptRequset
import hanaoka.hikikomori.uz.server.response.Message
import hanaoka.hikikomori.uz.server.retrofit.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LodingFragment : Fragment() {
    private val foodList : List<String> = listOf("사과", "양파", "계란", "파", "소고기", "소시지", "두리안", "감자", "버섯")
    private var _binding : FragmentLodingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentLodingBinding.inflate(inflater,container, false)
        Log.d("tag","testtesttinidninini")
        getGPT()
//        findNavController().navigate(R.id.action_lodingFragment_to_completedFragment)


        return binding.root
    }

    private fun getGPT(){
        lifecycleScope.launch (Dispatchers.IO) {
            kotlin.runCatching {
                val gpt = async (Dispatchers.IO) {
                    RetrofitBuilder.getGptService().getGpt(ChatGptRequset(
                        model = "gpt-4",
                        messages = listOf(Message(
                            role = "user",
                            content = "키  나이 몸무게 성별에 따라서 하루 3끼, 내가 주는 사람의 정보의 맞는 식단을 짜주 키는 162 몸무게는 50 나이는 17 성별은 남자야. 냉장고에 음식이 파프리카, 계란, 두리안, 감자, 김치, 돈까스, 콜라, 탄산수, 바나나가 있어. 간식은 추천 안 해줘도 돼고• 각• 음식당 • 총 칼로리를 아침 점심 저녁 각각 아침-음식이름-칼로리\\n형식으로 줘 데이터만 있으면 돼"
                        )),
                        temperature = 0.8

                    ))
                }
                gpt.await()
            }.onSuccess {
                Log.d("test", "${it.choices}")
                Log.d("test", "inininininin${it.choices}")
                launch(Dispatchers.Main) {
                    viewModel
                   val p = removeLastLine(it.choices[0].message.content)
                    Log.d("TAG", " data : ${p.split("-")}")
                    findNavController().navigate(R.id.action_lodingFragment_to_completedFragment)
                }

            }.onFailure {

                it.printStackTrace()
                if (it is HttpException) {
                    val errorBody = it.response()?.raw()?.request
                    Log.e("TAG", "Error body: $errorBody")
                    if(it.code() == 500){
                        delay(24000)
                        getGPT()
                    }
                }
            }
        }
    }

    data class Meal(val menu: List<String>, val kaloi: String)
    fun removeLastLine(text: String): String {
        val lines = text.split("\n")
        if (lines.size <= 1) return ""
        return lines.dropLast(1).joinToString("\n")
    }




}