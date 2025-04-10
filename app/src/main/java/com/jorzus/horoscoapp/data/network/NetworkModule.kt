package com.jorzus.horoscoapp.data.network

import com.jorzus.horoscoapp.BuildConfig.BASE_URL
import com.jorzus.horoscoapp.data.RepositoryImpl
import com.jorzus.horoscoapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module //etiqueta para que sea modulo
@InstallIn(SingletonComponent::class) //alcance de mi modulo, todos pueden inyectarse esto
object NetworkModule {
    //aqui puedo proveerme lo que quiera
    @Provides
    @Singleton //patron de ddiseño que nos permite tener una unica instancia de una clase
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    fun provideHoroscopoApiService(retrofit: Retrofit): HoroscopoApiService {
        return retrofit.create(HoroscopoApiService::class.java)
    }


    @Provides
    @Singleton
    fun provideOKHttpClient():OkHttpClient{
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()
    }


    @Provides
    fun providerRepository(apiService: HoroscopoApiService): Repository {
        return RepositoryImpl(apiService)
    }

}