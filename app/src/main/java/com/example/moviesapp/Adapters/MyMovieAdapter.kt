package com.example.moviesapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.Models.MyMovie
import com.example.moviesapp.databinding.ItemRvBinding

class MyMovieAdapter(var rvAction: RvAction, var list: ArrayList<MyMovie> = ArrayList()):RecyclerView.Adapter<MyMovieAdapter.Vh>() {

    inner class Vh(val itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBinding(myMovie: MyMovie){
            itemRvBinding.tvName.text = myMovie.name
            itemRvBinding.tvAuthors.text = myMovie.authors
            itemRvBinding.tvDate.text = myMovie.date

            itemRvBinding.root.setOnClickListener{
                rvAction.myItemClick(myMovie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBinding(list[position])
    }

    interface RvAction{
        fun myItemClick(movie: MyMovie)
    }
}