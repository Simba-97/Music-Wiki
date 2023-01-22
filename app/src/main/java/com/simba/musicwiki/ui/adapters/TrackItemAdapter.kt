package com.simba.musicwiki.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simba.musicwiki.data.models.tracks.Track
import com.simba.musicwiki.databinding.ItemDetailsLayoutBinding
import com.simba.musicwiki.utils.BindingUtils

class TrackItemAdapter(private var list: List<Track>) :
    RecyclerView.Adapter<TrackItemAdapter.ItemViewHolder>() {

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
                binding.tvDetail.text = this.name
                binding.tvAdditionalDetail.text = this.artist?.name ?: "Artist"
                BindingUtils.loadAndBindImage(
                    binding.ivImage,
                    this.image?.get(image.size - 1)?.text
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}