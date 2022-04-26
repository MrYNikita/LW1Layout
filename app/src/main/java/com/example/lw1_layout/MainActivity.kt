package com.example.lw1_layout

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lw1_layout.api.RetrofitClient
import com.example.lw1_layout.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.*

class MainActivity : AppCompatActivity() {
    private val adapter = Adapter()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() = with(binding) {

        rcView.layoutManager = LinearLayoutManager(this@MainActivity)
        getTariffs()
        getUsluga()
        getProfile(1)
        rcView.adapter = adapter

    }

    private fun getTariffs() {
        val service = RetrofitClient.retrofitService.getTarifsList().enqueue(
            object : Callback<List<Tarif>> {
                override fun onFailure(call: Call<List<Tarif>>, t: Throwable) {
                    //TODO("Not yet implemented")
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<List<Tarif>>,
                    response: Response<List<Tarif>>
                ) {

                    adapter.addHeader("Тарифы")
                    adapter.addToDataList(response.body())
                    adapter.notifyDataSetChanged();
                }
            }
        )
    }
    private fun getUsluga() {
        val service = RetrofitClient.retrofitService.getUslugaList().enqueue(
            object : Callback<List<Usluga>> {
                override fun onFailure(call: Call<List<Usluga>>, t: Throwable) {
                    //TODO("Not yet implemented")
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<List<Usluga>>,
                    response: Response<List<Usluga>>
                ) {
                    adapter.addHeader("Пользователь")
                    adapter.addToDataList(response.body())
                    adapter.notifyDataSetChanged();
                }
            }
        )
    }
    private fun getProfile(id: Int) {
        val service = RetrofitClient.retrofitService.getProfile(id).enqueue(
            object : Callback<Profile> {
                override fun onFailure(call: Call<Profile>, t: Throwable) {
                    //TODO("Not yet implemented")
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<Profile>,
                    response: Response<Profile>
                ) {
                    Log.d("PROFILE", response.body().toString())
                    adapter.addToDataList(response.body())
                    adapter.notifyDataSetChanged();
                }
            }
        )
    }

}