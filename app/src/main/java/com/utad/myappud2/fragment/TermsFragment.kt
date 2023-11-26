package com.utad.myappud2.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import com.bumptech.glide.Glide
import com.utad.myappud2.NewsListActivity
import com.utad.myappud2.R
import com.utad.myappud2.databinding.FragmentTermsBinding

class TermsFragment : Fragment() {




    private lateinit var _binding: FragmentTermsBinding
    private val binding: FragmentTermsBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTermsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this).load("https://www.cbatransfers.com/wp-content/uploads/2023/04/terminos-1300x760-1.png").into(binding.ivTerms)

        val name = arguments?.getString("name")
        binding.tvTerminos.text = getString(R.string.tv_terminos, name)

        val btnNext: Button = binding.btNews;
        val schEdad: Switch = binding.schEdad;

        schEdad.setOnClickListener { btnNext.isEnabled = schEdad.isChecked }

        btnNext.setOnClickListener {
            navigateToNews()
        }
    }


    private fun navigateToNews() {

        val intent = Intent(this.context, NewsListActivity::class.java)
        intent.putExtra("category",arguments?.getInt("category"))
        startActivity(intent)
    }

}