package com.example.picked.draftkotlin.ui.movie

import android.arch.lifecycle.MutableLiveData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.picked.draftkotlin.BR
import com.example.picked.draftkotlin.R
import com.example.picked.draftkotlin.data.Movie
import com.example.picked.draftkotlin.databinding.BindingHolder


class MovieListAdapter(var movieListLiveData: MutableLiveData<MutableList<Movie>>) : RecyclerView.Adapter<BindingHolder>() {

    override fun getItemCount() = movieListLiveData.value?.size ?: 0

    override fun onBindViewHolder(holder: BindingHolder?, position: Int) {
        holder?.binder?.setVariable(BR.movie, movieListLiveData.value?.get(position))
        holder?.binder?.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BindingHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_movie, parent, false)
        return BindingHolder(view)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)
        movieListLiveData.observeForever { notifyDataSetChanged() }
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView?) {
        super.onDetachedFromRecyclerView(recyclerView)
        movieListLiveData.removeObserver { this }
    }

}