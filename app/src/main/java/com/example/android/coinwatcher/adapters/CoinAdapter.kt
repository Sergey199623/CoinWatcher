package com.example.android.coinwatcher.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.coinwatcher.R
import com.example.android.coinwatcher.components.MyViewHolder
import com.example.android.coinwatcher.models.CoinCap
import kotlinx.android.synthetic.main.item_coin.view.*

class CoinAdapter : RecyclerView.Adapter<MyViewHolder>() {
    var mData:List<CoinCap>?=null
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_coin, parent, false))
    }

    override fun getItemCount(): Int {
        //если mData НЕ РАВНО null - вернуть size
        //если mData РАВНО null - вернуть 0
        return mData?.size?:0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        mData?.let {
            val coin = it.get(position)
            holder.view.tvSymbol.text=coin.symbol
            holder.view.tvName.text=coin.name
            holder.view.tvPrice.text="$(coin.price_usd)"
            holder.view.tvPriceChange.text=if(coin.percent_change_24gh>0)
                "+${coin.percent_change_24gh}%" else "${coin.percent_change_24gh}%"
        }
    }

}