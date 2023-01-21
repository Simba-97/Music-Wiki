package com.simba.musicwiki.ui.adapters

import android.provider.MediaStore.Audio.Albums
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.simba.musicwiki.ui.fragments.AlbumsFragment
import com.simba.musicwiki.ui.fragments.ArtistsFragment
import com.simba.musicwiki.ui.fragments.TracksFragment

class ProfileTabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    private val TAB_COUNT = 3

    override fun getItemCount(): Int {
        return TAB_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AlbumsFragment()
            1 -> ArtistsFragment()
            2 -> TracksFragment()
            else -> throw RuntimeException("Invalid position: $position")
        }
    }
}