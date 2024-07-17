package hanaoka.hikikomori.uz

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import hanaoka.hikikomori.uz.databinding.FragmentSingUpBinding
import hanaoka.hikikomori.uz.server.request.SignUpRequst
import hanaoka.hikikomori.uz.server.retrofit.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException


class SingUpFragment : Fragment() {
    private var _binding: FragmentSingUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSingUpBinding.inflate(inflater,container, false)

        binding.run {
            binding.nickNameEditText.doAfterTextChanged{ text ->  
                if(text.toString().isNotEmpty()){
                    binding.singUpButton.isEnabled = true
                }
                else{
                    binding.singUpButton.isEnabled = false
                }
            }
            binding.idEditText.doAfterTextChanged{ text ->
                if(text.toString().isNotEmpty()){
                    binding.singUpButton.isEnabled = true
                }
                else{
                    binding.singUpButton.isEnabled = false
                }
            }
            binding.passwordEditText.doAfterTextChanged{ text ->
                if(text.toString().isNotEmpty()){
                    binding.singUpButton.isEnabled = true
                }
                else{
                    binding.singUpButton.isEnabled = false
                }
            }
            binding.checkPasswordEditText.doAfterTextChanged{ text ->
                if(text.toString().isNotEmpty()){
                    binding.singUpButton.isEnabled = true
                }
                else{
                    binding.singUpButton.isEnabled = false
                }
            }
        }
        binding.singUpButton.setOnClickListener {
            signUp()
        }


        return binding.root
    }

    private fun signUp()
    {
        lifecycleScope.launch  (Dispatchers.IO)  {
            kotlin.runCatching {
               val body = SignUpRequst(
                    id = binding.idEditText.text.toString(),
                    name = binding.nickNameEditText.text.toString(),
                    password = binding.passwordEditText.text.toString()
                )
                Log.d("SingUpFragment", "$body")
                RetrofitBuilder.getLoginService().signUp(
                    body = body
                )
            }.onSuccess {
                Log.d("SingUpFragment", "resutl : $it")
                launch (Dispatchers.Main) {
                    findNavController().navigate(R.id.action_singUpFragment_to_userInfoFragment)
                }
            }.onFailure {
                launch (Dispatchers.Main) {
                    Toast.makeText(requireContext(), "다시 한 번 시도해 주세요.", Toast.LENGTH_SHORT).show()
                }
                if (it is HttpException) {
                    val errorBody = it.response()?.raw()?.request
                    Log.e("TAG", "Error body: $errorBody")
                }
                it.printStackTrace()
            }
        }
    }
}
//qwww