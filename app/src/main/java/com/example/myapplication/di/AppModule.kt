package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.db.RunningDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(@ApplicationContext app:Context) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        "My Database"
    ).build()

    @Singleton
    @Provides
    fun provideRunDAO(db:RunningDatabase) = db.getRunDao()
}