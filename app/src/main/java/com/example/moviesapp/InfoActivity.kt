package com.example.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesapp.Models.MyMovie
import com.example.moviesapp.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private val binding by lazy { ActivityInfoBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val myMovie: MyMovie = intent.getSerializableExtra("keyMovie") as MyMovie
        binding.apply {
            binding.tvName1.text = myMovie.name
            binding.tvName2.text = "Movie name: ${myMovie.name}"
            binding.tvAuthors.text = "Movie authors: ${myMovie.authors}"
            binding.tvAbout.text = "About movie: ${myMovie.aboutMovie}"
            binding.tvDate.text = "Movie date: ${myMovie.date}"
        }
        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}