package com.utad.myappud2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.utad.myappud2.R
import com.utad.myappud2.databinding.ActivityMainBinding
import com.utad.myappud2.databinding.ActivityNewsListBinding


class NewsListActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityNewsListBinding
    private val binding: ActivityNewsListBinding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFrangment = supportFragmentManager.findFragmentById(binding.fcvNavGraph.id)
        val controller = navHostFrangment?.findNavController()
        if(controller != null){
            binding.bnvNews.setupWithNavController(controller)
        }

        val selected = if(intent.getIntExtra("category",1) == 1) R.id.newsListFragment else if(intent.getIntExtra("category",1) == 2) R.id.sportListFragment else R.id.techListFragment
        binding.bnvNews.selectedItemId = selected
    }
}
