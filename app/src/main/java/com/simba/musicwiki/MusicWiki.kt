package com.simba.musicwiki

import android.app.Application
import com.simba.musicwiki.di.components.AppComponent
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MusicWiki : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        component().inject(this)
    }

    fun component(): AppComponent {
        return EntryPoints.get(this, AppComponent::class.java)
    }

    companion object {
        @get:Synchronized
        lateinit var instance: MusicWiki
    }
}