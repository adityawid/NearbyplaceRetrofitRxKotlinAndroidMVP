package com.devjurnal.nearbyplacerxkotlinandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.devjurnal.nearbyplacerxkotlinandroid.Models.ResponseServer
import com.devjurnal.nearbyplacerxkotlinandroid.Models.ResultsItem
import com.devjurnal.nearbyplacerxkotlinandroid.Presenters.NearbyAdapter
import com.devjurnal.nearbyplacerxkotlinandroid.Presenters.NearbyPresenterImp
import com.devjurnal.nearbyplacerxkotlinandroid.Views.NearbyViews
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NearbyViews {
    lateinit var presenter : NearbyPresenterImp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Network.service
                .getPlace()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                   t: ResponseServer? ->

                    var results = t?.results
                    var adapter = NearbyAdapter(results!!)
                    recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                    recyclerView.adapter = adapter
                    Log.d("data", t?.results.toString())
                }, {
                    e -> e.localizedMessage
                })*/
        initPresenter()
        initView()
    }

    private fun initView() {
        //presenter.getData()
        presenter.getData()
    }


    private fun initPresenter() {
        presenter = NearbyPresenterImp(this)
    }

    override fun Success(datas: List<ResultsItem?>) {
        var adapter = NearbyAdapter(datas)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = adapter
    }
    override fun Error(pesan: String) {
        Toast.makeText(applicationContext, ""+pesan, Toast.LENGTH_SHORT).show()
    }
}
