package com.btanguay.core.injection

import com.btanguay.DataStructureAndAlgorithmModule
import com.google.inject.AbstractModule
import com.google.inject.Provides

class MainModule: AbstractModule() {

    protected override fun configure() {
        install(DataStructureAndAlgorithmModule())
    }

    @Provides
    fun provideArrayList(): List<Any> = ArrayList()

    @Provides
    fun provideHashSet(): Set<Any> = HashSet()
}