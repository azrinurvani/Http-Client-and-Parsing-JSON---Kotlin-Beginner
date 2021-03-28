package com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.R
import com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.databinding.ActivityDetailBinding
import com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.model.DataItem

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fabBlog.setOnClickListener {view->
            Snackbar.make(view,"Replace with own your action",Snackbar.LENGTH_LONG)
                    .setAction("Action",null).show()
        }

        //Icon back pada toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        //terima data dari Intent menggunakan parcelable (tepatnya pada BlogAdapter)
        val dataIntent = intent.getParcelableExtra<DataItem>("DETAIL")

        if (dataIntent !=null){
            Glide.with(this)
                    .load(dataIntent.gambar)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.imgDetail)

            binding.toolbarCollaps.title = dataIntent.judul
            binding.contentScrolling.tvIsiDetail.text = dataIntent.isi
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}