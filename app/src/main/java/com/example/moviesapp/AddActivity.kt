package com.example.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.moviesapp.Models.MyMovie
import com.example.moviesapp.databinding.ActivityAddBinding
import com.example.moviesapp.utils.MySharedpreference

class AddActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        MySharedpreference.init(this)
        val list = MySharedpreference.list

        binding.apply {
            btnSave.setOnClickListener {
                val myMovia = MyMovie(
                    edtName.text.toString(),
                    edtAuthors.text.toString(),
                    edtAboutMovie.text.toString()
                )

                list.add(myMovia)
                MySharedpreference.list = list
                Toast.makeText(this@AddActivity, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}