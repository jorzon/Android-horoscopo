package com.jorzus.horoscoapp.data.core.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor( private val tokenSuscription: TokenSuscription):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .header("Autorization" , tokenSuscription.getToken()).build()

        return chain.proceed(request)
    }


}

class TokenSuscription(){
    fun getToken():String{
        return "holamundo"
    }
}