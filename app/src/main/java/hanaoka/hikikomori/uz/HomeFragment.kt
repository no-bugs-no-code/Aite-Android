package hanaoka.hikikomori.uz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import hanaoka.hikikomori.uz.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container, false)
        binding.generateMenuButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment2_to_isChangeRefrigeratorFragment2)
        }
        return binding.root
    }

}