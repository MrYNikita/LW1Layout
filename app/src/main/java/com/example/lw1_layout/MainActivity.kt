package com.example.lw1_layout

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lw1_layout.api.RetrofitClient
import com.example.lw1_layout.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.*

class MainActivity : AppCompatActivity() {
    private val adapter = Adapter()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch(Dispatchers.Main) {

            getTariffs()
            getUsluga()
            getProfile(1)

        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private suspend fun getTariffs() {
        adapter.addToDataList(RetrofitClient.retrofitService.getTarifsList())
    }
    private suspend fun getUsluga() {
        adapter.addToDataList(RetrofitClient.retrofitService.getUslugaList())
    }
    private suspend fun getProfile(id: Int) {
        adapter.addToDataList(RetrofitClient.retrofitService.getProfile(1))
    }

}