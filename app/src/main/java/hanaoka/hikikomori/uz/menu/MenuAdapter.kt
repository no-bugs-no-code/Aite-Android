package hanaoka.hikikomori.uz.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hanaoka.hikikomori.uz.databinding.ItemMenuListBinding
import hanaoka.hikikomori.uz.server.response.MenuResponse

class MenuAdapter(private val menuDataList: List<MenuResponse>, val change : (pos : Int, view : View) -> Unit): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    inner class MenuViewHolder(private val binding : ItemMenuListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(itemData : MenuResponse, pos: Int){
            binding.timelineText.text = itemData.timeLine
            binding.isLickImg.visibility = View.GONE
            binding.cardviewLayout.setOnClickListener { view ->
                change(pos, view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemMenuListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menuDataList[position], position)
    }

}