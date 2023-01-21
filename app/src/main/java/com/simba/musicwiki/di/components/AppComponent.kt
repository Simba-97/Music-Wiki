package com.simba.musicwiki.di.components

import com.simba.musicwiki.MusicWiki
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@EntryPoint
interface AppComponent {
    fun inject(app: MusicWiki?)
}