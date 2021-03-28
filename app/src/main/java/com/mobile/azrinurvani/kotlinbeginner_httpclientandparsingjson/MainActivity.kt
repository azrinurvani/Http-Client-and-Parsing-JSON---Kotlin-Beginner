package com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.api.ApiConfig
import com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.databinding.ActivityMainBinding
import com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.model.ResponseArtikel
import com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.view.adapter.BlogAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerAdapter : BlogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiConfig.service().getAllArtikel().enqueue(object: Callback<ResponseArtikel> {
            override fun onFailure(call: Call<ResponseArtikel>, t: Throwable) {
                binding.txtError.visibility = View.VISIBLE
                binding.txtError.text = "Error : ${t.localizedMessage}"
            }

            override fun onResponse(call: Call<ResponseArtikel>, response: Response<ResponseArtikel>) {
                if (response.isSuccessful){

                    //GET DATA FROM JSON BODY
                    val dataArtikel = response.body()?.data

                    recyclerAdapter = BlogAdapter(dataArtikel)

                    binding.rvBlog.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerAdapter.notifyDataSetChanged() //untuk me-redraw RecyclerView sehingga bisa menampilkan data yang baru
                        adapter = recyclerAdapter
                    }

                }
            }

        })
    }
}