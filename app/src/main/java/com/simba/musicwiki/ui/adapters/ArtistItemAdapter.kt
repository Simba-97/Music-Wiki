package com.simba.musicwiki.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simba.musicwiki.data.models.ArtistX
import com.simba.musicwiki.databinding.ItemDetailsLayoutBinding
import com.simba.musicwiki.utils.BindingUtils

class ArtistItemAdapter(private var list: List<ArtistX>) :
    RecyclerView.Adapter<ArtistItemAdapter.ItemViewHolder>() {

    var onItemClick: ((ArtistX) -> Unit)? = null


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
                binding.tvAdditionalDetail.text = this.name
                BindingUtils.loadAndBindImage(
                    binding.ivImage,
                    this.image?.get(image.size - 1)?.text
                )
            }
            holder.itemView.setOnClickListener {
                onItemClick?.invoke(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}