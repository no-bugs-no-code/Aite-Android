package hanaoka.hikikomori.uz.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hanaoka.hikikomori.uz.databinding.ItemFoodNameBinding

class FoodAdapter(private val foodList : List<String>) : RecyclerView.Adapter<FoodAdapter.FoodAdapterViewHolder>() {
    inner class FoodAdapterViewHolder(val binding : ItemFoodNameBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(name : String){
            binding.foodNameText.text = name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapterViewHolder {
        val binding = ItemFoodNameBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FoodAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int = foodList.size

    override fun onBindViewHolder(holder: FoodAdapterViewHolder, position: Int) {
        holder.bind(foodList[position])
    }
}