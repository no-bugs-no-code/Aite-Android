package hanaoka.hikikomori.uz

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import hanaoka.hikikomori.uz.databinding.FragmentLoginBinding


class loginFragment : Fragment() {
    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_singUpFragment)
        }

        return binding.root
    }

    private fun moveScreen(){
        startActivity(Intent(requireContext(), HomeActivity::class.java))
        requireActivity().finish()
    }

}