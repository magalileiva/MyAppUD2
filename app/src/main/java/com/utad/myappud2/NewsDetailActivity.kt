package com.utad.myappud2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.utad.myappud2.databinding.ActivityMainBinding
import com.utad.myappud2.databinding.ActivityNewsDetailBinding
import com.utad.myappud2.fragment.WelcomeFragment
import com.utad.myappud2.model.News

class NewsDetailActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityNewsDetailBinding
    private val binding: ActivityNewsDetailBinding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val news: News? = intent.getParcelableExtra("news")
        binding.tvDetailTitle.text = news?.title
        binding.tvAutor.text = news?.author
        binding.tvDetailNews.text = news?.description
        Glide.with(this).load(news?.image).into(binding.ivDetail)
    }
}