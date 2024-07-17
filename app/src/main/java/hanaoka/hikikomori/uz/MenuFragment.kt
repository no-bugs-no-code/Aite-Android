package hanaoka.hikikomori.uz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hanaoka.hikikomori.uz.databinding.FragmentHomeBinding
import hanaoka.hikikomori.uz.databinding.FragmentLoginBinding
import hanaoka.hikikomori.uz.databinding.FragmentMenuBinding
import hanaoka.hikikomori.uz.daymenu.DayMenuAdapter


class MenuFragment : Fragment() {

    private var _binding : FragmentMenuBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater,container, false)
        var tes = listOf("0000-00-00","0000-00-00","0000-00-00","0000-00-00","0000-00-00","0000-00-00","0000-00-00","0000-00-00")
        val adapter = DayMenuAdapter(tes, {pos ->
            val list = tes.toMutableList()
            list.removeAt(pos)
            tes = list
        })
        adapter.delete
        binding.daymenuRecyclerView.adapter = adapter


        return binding.root
    }


}