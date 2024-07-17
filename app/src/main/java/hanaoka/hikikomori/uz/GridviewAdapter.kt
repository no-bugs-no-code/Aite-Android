package hanaoka.hikikomori.uz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import hanaoka.hikikomori.uz.databinding.ItemButtonBinding

class GridviewAdapter : BaseAdapter() {
    private var buttonList = mutableListOf<ButtonStatus>()
    override fun getCount(): Int  = 9

    override fun getItem(position: Int): Any {
        return buttonList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }
    fun setItems(mutableList: MutableList<ButtonStatus>){
        buttonList = mutableList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val data = buttonList[position]
        val binding  = ItemButtonBinding.inflate(LayoutInflater.from(parent?.context))
        with(binding){
            buttonPanel.text = data.status.toString()
            buttonPanel.setOnClickListener {
                //TODO 상태보내기
            }
        }

        return binding.root
    }


}