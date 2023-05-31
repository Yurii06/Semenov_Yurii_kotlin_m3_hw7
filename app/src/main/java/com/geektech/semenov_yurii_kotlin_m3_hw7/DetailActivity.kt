package com.geektech.semenov_yurii_kotlin_m3_hw7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.semenov_yurii_kotlin_m3_hw7.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val phone = intent.getParcelableExtra<Phone>("phone")

        phone?.let {
            binding.imageViewOne.setImageResource(phone?.image ?: 0)
            binding.textViewTitleOne.text = phone?.title
            binding.textViewDescriptionOne.text = phone?.description
            binding.textViewPriceOne.text = phone?.price
            binding.textViewColorOne.text = phone?.color
        }
    }
}

