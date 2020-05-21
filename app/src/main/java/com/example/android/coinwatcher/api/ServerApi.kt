package com.example.android.coinwatcher.api

import com.example.android.coinwatcher.models.CoinCap
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ServerApi {
    @GET("ticker")
    fun loadData(@Query("limit")limit:Int=100):
            Deferred<List<CoinCap>>
}