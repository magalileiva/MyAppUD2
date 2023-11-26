package com.utad.myappud2.fragment

import android.R.attr.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.utad.myappud2.R
import com.utad.myappud2.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var _binding: FragmentWelcomeBinding
    private val binding: FragmentWelcomeBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnNext: Button = binding.btnTerms
        val cbGeneral: CheckBox = binding.chboxTodas
        val cbDeportes: CheckBox = binding.chboxDeportes
        val cbTecnologia: CheckBox = binding.chboxTecnologia
        val tvNombre: EditText = binding.ptName
        val image: ImageView = binding.ivWelcome

        Glide.with(this).load("https://play-lh.googleusercontent.com/R6YzQy3BvYaMZ6BrnDw7fUdXskhTPqOIHLz42gfynLEm4aOo81fCsJVev-N9MrE9vQ").into(image)


        cbGeneral.setOnClickListener {
            cbDeportes.isChecked = false;
            cbTecnologia.isChecked = false;
            btnNext.isEnabled = true;
        }

        cbDeportes.setOnClickListener {
            cbGeneral.isChecked = false;
            cbTecnologia.isChecked = false;
            btnNext.isEnabled = true;
        }

        cbTecnologia.setOnClickListener {
            cbDeportes.isChecked = false;
            cbGeneral.isChecked = false;
            btnNext.isEnabled = true;
        }

        btnNext.setOnClickListener {
            if(tvNombre.text.toString()!="" && (cbGeneral.isChecked || cbDeportes.isChecked || cbTecnologia.isChecked)) {
                navigateToTerms()
            }else{
                Toast.makeText(this.context, "Complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToTerms() {
        val secondFragment = TermsFragment()
        val transaction = parentFragmentManager.beginTransaction()
        val arguments = Bundle()
        val categoria: Int = if(binding.chboxTodas.isChecked) 1 else if(binding.chboxDeportes.isChecked) 2 else 3

        arguments.putInt("category", categoria)
        arguments.putString("name", binding.ptName.text.trim().toString())
        secondFragment.arguments = arguments

        transaction.setReorderingAllowed(true)
        transaction.replace(R.id.fcv_main, secondFragment)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.addToBackStack("welcome")
        transaction.commit()
    }


}