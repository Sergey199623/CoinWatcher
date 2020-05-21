package com.example.android.coinwatcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.coinwatcher.adapters.CoinAdapter
import com.example.android.coinwatcher.api.ServiceGenerator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.android.UI
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var adapter:CoinAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView.layoutManager=LinearLayoutManager(this)
        adapter = CoinAdapter()
        recycleView.adapter=adapter

        loadData()
    }

    private fun loadData() {
        launch(UI) {
            try {
                adapter.mData=ServiceGenerator.serverApi.loadData(10).await()
            }catch (ex:Exception) {
                Toast.makeText(this@MainActivity, R.string.no_connection,
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}
