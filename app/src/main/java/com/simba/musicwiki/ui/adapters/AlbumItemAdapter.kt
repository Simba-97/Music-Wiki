package com.simba.musicwiki.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simba.musicwiki.data.models.album.Album
import com.simba.musicwiki.databinding.ItemDetailsLayoutBinding
import com.simba.musicwiki.utils.BindingUtils

class AlbumItemAdapter(private var list: List<Album>) :
    RecyclerView.Adapter<AlbumItemAdapter.ItemViewHolder>() {

    var onItemClick: ((Album) -> Unit)? = null

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
                binding.tvDetail.text = this.artist?.name ?: "No artist"
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