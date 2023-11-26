package com.utad.myappud2.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.myappud2.NewsDetailActivity
import com.utad.myappud2.R
import com.utad.myappud2.adapter.NewsAdapter
import com.utad.myappud2.data.sportNews
import com.utad.myappud2.data.techNews
import com.utad.myappud2.databinding.FragmentNewsListBinding
import com.utad.myappud2.databinding.FragmentSportListBinding
import com.utad.myappud2.model.News

class SportListFragment : Fragment() {

    private lateinit var _binding: FragmentSportListBinding
    private val binding: FragmentSportListBinding get() = _binding

    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSportListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvNews.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
        adapter = NewsAdapter(sportNews){navigateToDetail(it)}
        binding.rvNews.adapter = adapter
    }

    private fun navigateToDetail(news: News) {
        val intent = Intent(this.context, NewsDetailActivity::class.java)
        intent.putExtra("news", news)
        startActivity(intent)
    }


}