package com.devjurnal.nearbyplacerxkotlinandroid.Views

import com.devjurnal.nearbyplacerxkotlinandroid.Models.ResultsItem

/**
 * Created by DevJurnal on 2/18/18.
 */
interface NearbyViews {
    // jika sukses menampilkan arraylist ke adapter
    fun Success (datas: List<ResultsItem?>)

    fun Error(pesan : String)

}