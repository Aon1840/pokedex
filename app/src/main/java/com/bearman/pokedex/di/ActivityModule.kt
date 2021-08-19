package com.bearman.pokedex.di


import com.bearman.pokedex.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
@Suppress("unused")
abstract class ActivityModule {
    @ContributesAndroidInjector(
        modules = [
            FragmentModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}
