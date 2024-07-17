package hanaoka.hikikomori.uz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import hanaoka.hikikomori.uz.databinding.FragmentFailBinding
import hanaoka.hikikomori.uz.databinding.FragmentLodingBinding

class FailFragment : Fragment() {
    private var _binding : FragmentFailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentFailBinding.inflate(inflater,container,false)

        binding.closeButton.setOnClickListener {
            (requireActivity() as BottomControllable).setBottomNavVisibility(true)
            findNavController().navigate(R.id.action_failFragment_to_homeFragment2)
        }

        binding.rePotoButton.setOnClickListener {
            findNavController().navigate(R.id.action_failFragment_to_isChangeRefrigeratorFragment2)
        }

        return binding.root
    }
}