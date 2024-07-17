package hanaoka.hikikomori.uz

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import hanaoka.hikikomori.uz.databinding.FragmentSingUpBinding


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
                if(text.toString().length >= 8){
                    binding.singUpButton.isEnabled = true
                }
                else{
                    binding.singUpButton.isEnabled = false
                }
            }
            binding.idEditText.doAfterTextChanged{ text ->
                if(text.toString().length >= 8){
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
            findNavController().navigate(R.id.action_singUpFragment_to_userInfoFragment)
        }


        return binding.root
    }

}