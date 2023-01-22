package com.simba.musicwiki.ui.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.simba.musicwiki.ui.fragments.AlbumsFragment
import com.simba.musicwiki.ui.fragments.ArtistsFragment
import com.simba.musicwiki.ui.fragments.TracksFragment

class ProfileTabAdapter(activity: AppCompatActivity, tag: String) : FragmentStateAdapter(activity) {

    private val tag = tag

    private val TAB_COUNT = 3

    override fun getItemCount(): Int {
        return TAB_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AlbumsFragment(tag)
            1 -> ArtistsFragment(tag)
            2 -> TracksFragment(tag)
            else -> throw RuntimeException("Invalid position: $position")
        }
    }
}