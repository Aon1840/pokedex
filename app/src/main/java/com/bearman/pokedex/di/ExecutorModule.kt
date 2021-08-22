package com.bearman.pokedex.di

import com.bearman.pokedex.data.JobExecutor
import com.bearman.pokedex.domain.executor.PostExecutionThread
import com.bearman.pokedex.domain.executor.ThreadExecutor
import com.bearman.pokedex.view.UIThread
import dagger.Binds
import dagger.Module

@Module
@Suppress("unused")
abstract class ExecutorModule {

    @Binds
    abstract fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UIThread): PostExecutionThread
}