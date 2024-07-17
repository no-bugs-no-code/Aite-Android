package hanaoka.hikikomori.uz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hanaoka.hikikomori.uz.databinding.ItemFoodBinding

class MenuItemFoodAdapter(private val itemList : List<String>, val changeData : (view : View, pos : Int) -> Unit) : RecyclerView.Adapter<MenuItemFoodAdapter.ItemFoodViewHolder>() {
    inner class ItemFoodViewHolder(private val binding : ItemFoodBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(itemData : String, pos : Int){
            binding.foodNameText.text = itemData

            binding.verticButton.setOnClickListener {
                changeData(it, pos)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemFoodViewHolder(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ItemFoodViewHolder, position: Int) {
        holder.bind(itemList[position], position)
    }
}