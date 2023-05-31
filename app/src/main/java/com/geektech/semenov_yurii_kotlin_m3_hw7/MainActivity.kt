package com.geektech.semenov_yurii_kotlin_m3_hw7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.semenov_yurii_kotlin_m3_hw7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var phoneAdapter: PhoneAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        phoneAdapter = PhoneAdapter(phoneList.toMutableList() as ArrayList<Phone>) { phone ->
            showDetailScreen(phone)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = phoneAdapter
        }
    }

    private val phoneList = listOf(
        Phone(
            R.drawable.ic_iphone,
            "Iphone13",
            "iPhone 13 является базовой моделью 15-го поколения. Содержит процессор Apple A15 в котором 15 млрд транзисторов. ",
            "$100",
            "Black"
        ),
        Phone(
            R.drawable.ic_galaxy,
            "Samsung Galaxy S22",
            "Тут стоит дисплей с диагональю 6.1 дюйм, что на 0.1 дюйм меньше, чем у S21, но это заметно лишь с той точки зрения, что смартфон стал чуть компактнее. ",
            "$200",
            "White"
        ),
        Phone(
            R.drawable.ic_xiaome,
            "Xiaomi Mi 11 Ultra",
            "Xiaomi Mi 11 Ultra — молниеносный смартфон класса Ультра. Здесь сверхмощная квадрокамера, изумительный HDR10+ дисплей и ультрабыстрый процессор.",
            "$300",
            "Blue"
        )
    )


    private fun showDetailScreen(phone: Phone) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("phone", phone)
        startActivity(intent)
    }
}
