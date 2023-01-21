package com.simba.musicwiki.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simba.musicwiki.databinding.ItemDetailsLayoutBinding

class ItemAdapter(private var list: List<String>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemDetailsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ItemDetailsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.tvAdditionalDetail.text = this
                binding.tvDetail.text = this
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}