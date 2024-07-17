package hanaoka.hikikomori.uz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import hanaoka.hikikomori.uz.databinding.FragmentCompletedBinding
import hanaoka.hikikomori.uz.databinding.FragmentHomeBinding
import hanaoka.hikikomori.uz.menu.CheckMenuAdapter
import hanaoka.hikikomori.uz.menu.MenuDeco
import hanaoka.hikikomori.uz.server.response.DayResponse

class CompletedFragment : Fragment() {
    private var _binding : FragmentCompletedBinding? = null
    private val binding get() = _binding!!
    private val foodList : DayResponse = DayResponse()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCompletedBinding.inflate(inflater, container, false)
        val adapter = CheckMenuAdapter(foodList)
        binding.reSetButton.setOnClickListener {
            Log.d("tag","testtesttinidninini")
            findNavController().navigate(R.id.action_completedFragment_to_lodingFragment)

        }

        binding.resultSaveButton.setOnClickListener {
            (requireActivity() as BottomControllable).setBottomNavVisibility(true)
            findNavController().navigate(R.id.action_completedFragment_to_homeFragment2)
        }

        adapter.notifyItemRemoved(0)
        binding.menuRecyclerView.adapter = adapter
        binding.menuRecyclerView.addItemDecoration(MenuDeco(14,2))
        return binding.root
    }
}