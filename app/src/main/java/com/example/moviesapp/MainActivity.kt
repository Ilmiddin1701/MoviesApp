package com.example.moviesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesapp.Adapters.MyMovieAdapter
import com.example.moviesapp.Models.MyMovie
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.utils.MySharedpreference

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var myMovieAdapter: MyMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        MySharedpreference.init(this)
        val list = MySharedpreference.list

        myMovieAdapter = MyMovieAdapter(object : MyMovieAdapter.RvAction{
            override fun myItemClick(movie: MyMovie) {
                val intent = Intent(this@MainActivity, InfoActivity::class.java)
                intent.putExtra("keyMovie", movie)
                startActivity(intent)
            }
        }, list)
        binding.rv.adapter = myMovieAdapter
    }
}