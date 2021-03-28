package com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.R
import com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.databinding.ItemRowBlogBinding
import com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.model.DataItem
import com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.view.DetailActivity

class BlogAdapter(val dataArtikel : List<DataItem?>? ) : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>(){

    private lateinit var itemRowBinding: ItemRowBlogBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        itemRowBinding = ItemRowBlogBinding.inflate(layoutInflater,parent,false)
        return BlogViewHolder(itemRowBinding)
    }

    override fun getItemCount(): Int {
        if (dataArtikel !=null){
            return dataArtikel.size
        }else{
            return 0
        }
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
                .load(dataArtikel?.get(position)?.gambar)
                .error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.image)

        holder.title.text = dataArtikel?.get(position)?.judul.toString()
        holder.author.text = dataArtikel?.get(position)?.author.toString()
        holder.date.text = dataArtikel?.get(position)?.tglPosting.toString()

        val context = holder.itemView.context

        holder.itemView.setOnClickListener {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("DETAIL",dataArtikel?.get(position))
            context.startActivity(intent)
        }

    }


    class BlogViewHolder(binding: ItemRowBlogBinding): RecyclerView.ViewHolder(binding.root) {
        val image = binding.imgBlog
        val title = binding.txtTitleBlog
        val author = binding.txtAuthorBlog
        val date = binding.txtDateBlog
    }
}