package com.devjurnal.nearbyplacerxkotlinandroid.Presenters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devjurnal.nearbyplacerxkotlinandroid.Models.ResultsItem
import com.devjurnal.nearbyplacerxkotlinandroid.R
import kotlinx.android.synthetic.main.item_recycler.view.*

/**
 * Created by DevJurnal on 2/18/18.
 */
class NearbyAdapter(data: List<ResultsItem?>) : RecyclerView.Adapter<NearbyAdapter.MyHolder>() {
     var ambilData : List<ResultsItem?>
    init {
        this.ambilData = data
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_recycler, parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return ambilData.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(ambilData, position)
    }

    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(ambilData: List<ResultsItem?>, position: Int) {
            itemView.tvItemNama.text = ambilData.get(position)?.name
            itemView.tvItemAlamat.text = ambilData.get(position)?.vicinity
            itemView.tvItemRating.text = ambilData.get(position)?.rating.toString()

            if(ambilData.get(position)?.rating != null ){
                itemView.ratingItem.rating = ambilData.get(position)?.rating!!
            }else{
                var rating = 0
                itemView.ratingItem.rating = rating.toFloat()
            }

        }

    }
}