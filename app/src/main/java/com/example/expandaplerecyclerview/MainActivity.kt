package com.example.expandaplerecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expandaplerecyclerview.adapters.PersonAdapter
import com.example.expandaplerecyclerview.data.model.Person
import com.example.expandaplerecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val personlist = arrayListOf(
            Person(1,"Osman","ssssssssssssssssssssssssssss"),
            Person(2,"Ahmet","ssssssssssssssssssssssssssss"),
            Person(3,"Mehmet","ssssssssssssssssssssssssssss"),
            Person(4,"Mahmut","ssssssssssssssssssssssssssss"),
            Person(5,"Dangalak","ssssssssssssssssssssssssssss"),
            Person(5,"Dangalak","ssssssssssssssssssssssssssss"),
            Person(5,"Dangalak","ssssssssssssssssssssssssssss"),
            Person(5,"Dangalak","ssssssssssssssssssssssssssss"),
            Person(5,"Dangalak","ssssssssssssssssssssssssssss"),
            Person(5,"Dangalak","ssssssssssssssssssssssssssss")
        )

        val adapter = PersonAdapter(personlist)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }
}