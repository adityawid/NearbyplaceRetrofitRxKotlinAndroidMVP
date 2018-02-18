package com.devjurnal.nearbyplacerxkotlinandroid

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by DevJurnal on 2/18/18.
 */
object Network {

    // configurasi retrofit
    // todo (1) Retrofit CONFIGRetrofit.kt
    val retrofit = Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/maps/api/place/nearbysearch/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    // Service yang dipanggil di presenter
    val service = retrofit.create<ApiService>(ApiService::class.java!!)
}