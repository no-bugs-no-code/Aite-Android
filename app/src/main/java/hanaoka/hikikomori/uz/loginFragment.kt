package hanaoka.hikikomori.uz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import hanaoka.hikikomori.uz.databinding.FragmentLoginBinding
import hanaoka.hikikomori.uz.server.request.LoginRequest
import hanaoka.hikikomori.uz.server.retrofit.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException


class loginFragment : Fragment() {
    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        binding.loginButton.setOnClickListener {
            logIn()
        }
        binding.signInText.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_singUpFragment)
        }

        return binding.root
    }

    private fun moveScreen(){
        startActivity(Intent(requireContext(), HomeActivity3::class.java))
        requireActivity().finish()
    }

    private fun logIn(){
        val body = LoginRequest(
            id = binding.idEditText.text.toString(),
            password = binding.passwordEditText.text.toString()
        )
        Log.d("test", "$body")
        lifecycleScope.launch (Dispatchers.IO){
            kotlin.runCatching {
                RetrofitBuilder.getLoginService().login(
                    requestBody = LoginRequest(
                        id = binding.idEditText.text.toString(),
                        password = binding.passwordEditText.text.toString()
                    )
                )
            }.onSuccess {
                Log.d("loginFragment", "result : $it")
                launch(Dispatchers.Main) { moveScreen() }
            }.onFailure {
                it.printStackTrace()
                if (it is HttpException) {
                    val errorBody = it.response()?.raw()?.request
                    Log.e("TAG", "Error body: $errorBody")
                }
                launch(Dispatchers.Main) {  Toast.makeText(requireContext(), "확실하게 입력하였는지 확인해 주십시오.", Toast.LENGTH_SHORT).show() }


            }

        }
    }

}