package hanaoka.hikikomori.uz.daymenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hanaoka.hikikomori.uz.databinding.ItemDayMenuBinding

class DayMenuAdapter(private val menuList: List<String>, val delete : (pos : Int) -> Unit) :RecyclerView.Adapter<DayMenuAdapter.DayMenuViewHolder>(){
    inner class DayMenuViewHolder(val binding : ItemDayMenuBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(date : String, pos : Int){
            binding.deleteButton.setOnClickListener {
                delete(pos)
            }

            val m = date.split("-")[1]
            val d = date.split("-")[2]

            binding.dateText.text = "${m}월 ${d}일 메뉴판"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayMenuViewHolder {
            val binding = ItemDayMenuBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return DayMenuViewHolder(binding)
    }

    override fun getItemCount(): Int  = menuList.size

    override fun onBindViewHolder(holder: DayMenuViewHolder, position: Int) {
        holder.bind(menuList[position], position)
    }
}