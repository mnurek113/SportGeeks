package com.code.knab.sportgeeks.network.api

import com.code.knab.sportgeeks.network.RetrofitProvider
import retrofit2.Retrofit

class NetworkApiProvider {
    private val signUpApi: SignUpApi? = null
    private var retrofitProvider: RetrofitProvider = RetrofitProvider()
    private var retrofit:Retrofit = retrofitProvider.retrofit

    public fun createSignUpApi() = retrofit.create(SignUpApi::class.java)
    public fun createSignInApi() = retrofit.create(SignInApi::class.java)

}