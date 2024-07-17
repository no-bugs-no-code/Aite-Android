package hanaoka.hikikomori.uz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import hanaoka.hikikomori.uz.databinding.FragmentUpdateRefegiratiorBinding
import hanaoka.hikikomori.uz.refrigerator.RefrigeratorViewModel


class UpdateRefegiratiorFragment : Fragment() {

    private val TAG ="UpdateRefegiratiorFragment"

    private var _binding : FragmentUpdateRefegiratiorBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<RefrigeratorViewModel>()
    private var foodList : List<String> = listOf("사과", "양파", "계란", "파", "소고기", "소시지", "두리안", "감자", "버섯")
    private lateinit var foodAdapter : MenuItemFoodAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUpdateRefegiratiorBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        binding.myRefragmentImg.setImageBitmap(viewModel.imageBitmap.value)

        binding.menuGrneraitonButton.setOnClickListener {
            findNavController().navigate(R.id.action_nextFragment2_to_lodingFragment)
        }
        initRecyclerView()


        return binding.root
    }

    private fun initRecyclerView(){
        val foodAdapter = MenuItemFoodAdapter(
            itemList =  foodList,
            changeData =  { view, pos ->
                val pop = PopupMenu(requireContext(), view)

                pop.menuInflater.inflate(R.menu.food_vertac_menu, pop.menu)

                pop.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.modify -> {
                            Log.d(TAG, "modify")
                        }
                        R.id.delet -> {
                            Log.d(TAG, "delet")
                            val list =  foodList.toMutableList()
                            list.removeAt(pos)
                            foodList = list
//                            update()
                        }
                    }
                    false
                }
                pop.show()
            })
        foodAdapter.notifyItemRemoved(0)
        binding.itemRecyclerView.adapter = foodAdapter
    }

    private fun update(){
        foodAdapter.notifyItemRemoved(0)
    }
}