package hanaoka.hikikomori.uz

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import hanaoka.hikikomori.uz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: GridviewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrat = mutableListOf(ButtonStatus(-1),ButtonStatus(-1),ButtonStatus(-1),ButtonStatus(-1),ButtonStatus(-1),ButtonStatus(-1),ButtonStatus(-1),ButtonStatus(-1),ButtonStatus(-1))


        adapter = GridviewAdapter()
        adapter.setItems(arrat)
        binding.gridView.adapter = adapter


    }
}