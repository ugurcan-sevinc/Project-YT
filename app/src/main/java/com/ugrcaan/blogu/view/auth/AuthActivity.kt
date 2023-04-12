package com.ugrcaan.blogu.view.auth

import android.graphics.Shader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ugrcaan.blogu.R
import com.ugrcaan.blogu.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}