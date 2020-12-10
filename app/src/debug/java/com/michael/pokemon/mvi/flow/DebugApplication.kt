package com.michael.pokemon.mvi.flow

import com.michael.api.DebugApi

class DebugApplication: MyApplication() {

    override fun onCreate() {
        super.onCreate()
        DebugApi.initializeHttpLogger(this)
    }
}