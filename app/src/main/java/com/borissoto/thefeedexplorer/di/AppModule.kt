package com.borissoto.thefeedexplorer.di

import com.borissoto.thefeedexplorer.common.Constants
import com.borissoto.thefeedexplorer.data.remote.DoctorApi
import com.borissoto.thefeedexplorer.data.repository.DoctorRepositoryImpl
import com.borissoto.thefeedexplorer.domain.repository.DoctorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDoctorsApi(): DoctorApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DoctorApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDoctorsRepository(api: DoctorApi): DoctorRepository{
        return DoctorRepositoryImpl(api)
    }
}