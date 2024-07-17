package hanaoka.hikikomori.uz

import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import hanaoka.hikikomori.uz.databinding.FragmentCompletedBinding
import hanaoka.hikikomori.uz.databinding.FragmentHomeBinding
import hanaoka.hikikomori.uz.menu.CheckMenuAdapter
import hanaoka.hikikomori.uz.menu.MenuDeco
import hanaoka.hikikomori.uz.refrigerator.RefrigeratorViewModel
import hanaoka.hikikomori.uz.server.response.DayResponse
import java.util.GregorianCalendar

class CompletedFragment : Fragment() {
    private var _binding : FragmentCompletedBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<RefrigeratorViewModel>()
    private val foodList : DayResponse = DayResponse()

    private val gregorianCalendar = GregorianCalendar()
    private val year = gregorianCalendar.get(Calendar.YEAR)
    private val date = gregorianCalendar.get(Calendar.DATE)
    private val month = gregorianCalendar.get(Calendar.MONTH)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCompletedBinding.inflate(inflater, container, false)
        val adapter = CheckMenuAdapter(viewModel.itemData.value!!)

        binding.dayTitleText.text = "$${month+1}월 ${date}일의 생성된 식단표"
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