package com.utad.myappud2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utad.myappud2.databinding.ActivityMainBinding
import com.utad.myappud2.fragment.WelcomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var _binding:  ActivityMainBinding
    private val binding: ActivityMainBinding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myInitialFragment = WelcomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.add(binding.fcvMain.id, myInitialFragment)
        transaction.commit()
    }
}