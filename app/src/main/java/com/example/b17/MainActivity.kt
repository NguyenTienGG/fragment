package com.example.b17

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.b17.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sub1 = Fragment1()
        val sub2 = Fragment2()


        binding.btnf1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl1, sub1)
                commit()
            }
        }
        binding.btnf2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl1, sub2)
                commit()
            }
        }
    }
}