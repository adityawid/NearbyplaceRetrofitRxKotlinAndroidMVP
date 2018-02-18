package com.devjurnal.nearbyplacerxkotlinandroid

import com.devjurnal.nearbyplacerxkotlinandroid.Models.ResponseServer
import com.devjurnal.nearbyplacerxkotlinandroid.Models.ResultsItem
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by DevJurnal on 2/18/18.
 */
interface ApiService {
    // TODO 2 buat api service.kt
    // request to Server
    @GET("json?location=-7.0539427,110.429695&radius=500&type=restaurant&key=AIzaSyAqPRoyjGgZ9S1lQkW44zZluhmCTK0eSZc")
    fun getPlace(): Observable<ResponseServer>
}