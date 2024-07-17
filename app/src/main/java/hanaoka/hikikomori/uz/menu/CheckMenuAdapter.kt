package hanaoka.hikikomori.uz.menu

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hanaoka.hikikomori.uz.R
import hanaoka.hikikomori.uz.databinding.ItemMenuListBinding
import hanaoka.hikikomori.uz.server.response.DayResponse
import hanaoka.hikikomori.uz.server.response.MenuResponse

class CheckMenuAdapter(private val menuDataList: DayResponse): RecyclerView.Adapter<CheckMenuAdapter.CheckMenuViewHolder>() {
    inner class CheckMenuViewHolder(private val binding : ItemMenuListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(itemData : MenuResponse, pos : Int){
            var isLocked : Boolean = false
            if(pos == 0){
                binding.timelineText.text = itemData.timeLine
                val adapter : FoodAdapter = FoodAdapter(itemData.menuList!!)
                adapter.notifyItemRemoved(0)
                binding.foodRecyclerView.adapter = adapter
            }
            else if(pos == 1){
                binding.timelineText.text = "점심"
                val adapter : FoodAdapter = FoodAdapter(itemData.menuList!!)
                adapter.notifyItemRemoved(0)
                binding.foodRecyclerView.adapter = adapter
            }
            else{
                binding.timelineText.text = "저녁"
                val adapter : FoodAdapter = FoodAdapter(itemData.menuList!!)
                adapter.notifyItemRemoved(0)
                binding.foodRecyclerView.adapter = adapter
            }
//            binding.timelineText.text = itemData.timeLine
//            val adapter : FoodAdapter = FoodAdapter(itemData.menuList!!)
//            adapter.notifyItemRemoved(0)
//            binding.foodRecyclerView.adapter = adapter

            binding.cardviewLayout.setOnClickListener { view ->
                if(isLocked){
                    binding.isLickImg.setImageResource(R.drawable.ic_unlock)
                }else{
                    binding.isLickImg.setImageResource(R.drawable.ic_lock)

                }
                Log.d("test", isLocked.toString())
                isLocked = isLocked.not()
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckMenuViewHolder {
        val binding = ItemMenuListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CheckMenuViewHolder(binding)
    }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: CheckMenuViewHolder, position: Int) {
        holder.bind(menuDataList.menus!![position], position)
    }

}