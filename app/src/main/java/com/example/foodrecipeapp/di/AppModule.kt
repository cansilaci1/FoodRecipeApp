package com.example.foodrecipeapp.di

import com.example.foodrecipeapp.data.repo.FoodDaRepository
import com.example.foodrecipeapp.retrofit.APIUtils
import com.example.foodrecipeapp.retrofit.FoodDao
import com.google.firebase.firestore.CollectionReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFoodDaRepository(fdao: FoodDao) : FoodDaRepository{

        return FoodDaRepository(fdao)
    }

    @Provides
    @Singleton
    fun provideFoodDao() : FoodDao{

        return APIUtils.getFoodDao()
    }
}