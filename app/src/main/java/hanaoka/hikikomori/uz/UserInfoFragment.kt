package hanaoka.hikikomori.uz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import hanaoka.hikikomori.uz.databinding.FragmentUserInfoBinding

class UserInfoFragment : Fragment() {
    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUserInfoBinding.inflate(inflater,container, false)
        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_userInfoFragment_to_loginFragment)
        }

        binding.nextText.setOnClickListener {
            findNavController().navigate(R.id.action_userInfoFragment_to_loginFragment)
        }

        binding.run {
            binding.birthEditText.doAfterTextChanged{ text ->
                if(text.toString().length >= 8){
                    binding.signUpButton.isEnabled = true
                }
                else{
                    binding.signUpButton.isEnabled = false
                }
            }
            binding.weightEditText.doAfterTextChanged{ text ->
                if(text.toString().length >= 8){
                    binding.signUpButton.isEnabled = true
                }
                else{
                    binding.signUpButton.isEnabled = false
                }
            }
            binding.heightEditText.doAfterTextChanged{ text ->
                if(text.toString().length >= 8){
                    binding.signUpButton.isEnabled = true
                }
                else{
                    binding.signUpButton.isEnabled = false
                }
            }
        }
        return binding.root
    }
}