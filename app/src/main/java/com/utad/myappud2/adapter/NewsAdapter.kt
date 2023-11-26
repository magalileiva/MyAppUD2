package com.utad.myappud2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utad.myappud2.databinding.ItemNewsBinding
import com.utad.myappud2.model.News

class NewsAdapter(
    private var newsList: List<News>,
    private var onClick: (News) -> Unit
):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater =  LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item: News = newsList.get(position)
        holder.binding.tvNewsTitle.text = item.title
        Glide.with(holder.binding.ivNews.context).load(item.image).into(holder.binding.ivNews)
        holder.binding.root.setOnClickListener { onClick(item) }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun updateList(list: List<News>){
        newsList = list;
    }

    inner class NewsViewHolder(val binding: ItemNewsBinding):RecyclerView.ViewHolder(binding.root)
}