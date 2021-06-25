package com.andersenlab.rickandmorty.app

import android.app.Application
import com.andersenlab.rickandmorty.di.Injector

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Injector.initAppComponent(this)
    }

}