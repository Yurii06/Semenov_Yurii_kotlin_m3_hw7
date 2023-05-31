package com.geektech.semenov_yurii_kotlin_m3_hw7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geektech.semenov_yurii_kotlin_m3_hw7.databinding.ItemPhoneBinding

class PhoneAdapter(
    private val phoneList: ArrayList<Phone>,
    private val onItemClick: (Phone) -> Unit
) :
    RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPhoneBinding.inflate(inflater, parent, false)
        return PhoneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val phone = phoneList[position]
        holder.onBind(phone)
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

    inner class PhoneViewHolder(private val binding: ItemPhoneBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val phone = phoneList[position]
                    onItemClick(phone)
                }
            }
        }

        fun onBind(phone: Phone) {
            binding.imageView.setImageResource(phone.image)
            binding.textViewTitle.text = phone.title
            binding.textViewDescription.text = phone.description
            binding.textViewPrice.text = phone.price
            binding.textViewColor.text = phone.color
        }
    }
}

