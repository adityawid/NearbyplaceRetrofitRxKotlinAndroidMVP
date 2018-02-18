package com.devjurnal.nearbyplacerxkotlinandroid.Presenters

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.devjurnal.nearbyplacerxkotlinandroid.Models.ResponseServer
import com.devjurnal.nearbyplacerxkotlinandroid.Models.ResultsItem
import com.devjurnal.nearbyplacerxkotlinandroid.Network
import com.devjurnal.nearbyplacerxkotlinandroid.R.id.recyclerView
import com.devjurnal.nearbyplacerxkotlinandroid.Views.NearbyViews
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by DevJurnal on 2/18/18.
 */
class NearbyPresenterImp : NearbyPresenter{

    var nearbyViews : NearbyViews? = null



    override fun getData() {
        /*Network.service
                .getPlace()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    t: ResponseServer? ->

                    var result = t?.results


                    Log.d("data", t?.results.toString())
                }, {
                    e -> e.localizedMessage
                })*/

        Network.service
                .getPlace()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                   t: ResponseServer? ->

                    var result = t?.results
                    var adapter = NearbyAdapter(result!!)
                    nearbyViews?.Success(result!!)
//                    recyclerView.layoutManager = LinearLayoutManager(applicationContext)
//                    recyclerView.adapter = adapter
                    Log.d("data", t?.results.toString())
                }, {
                    e -> e.localizedMessage
                })
    }

    constructor(nearbyViews: NearbyViews?) {
        this.nearbyViews = nearbyViews
    }

//    override fun addList(result: List<ResultsItem?>) {
//        results.add(result)
//
//        nearbyViews?.Success(results)
//    }


}