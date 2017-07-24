package com.example.picked.draftkotlin.databinding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.example.picked.draftkotlin.R
import com.squareup.picasso.Picasso


@BindingAdapter("bind:imageUrl")
fun bindImageUrl(imageView: ImageView?, imageUrl: String) {
    imageView?.let {
        Picasso.with(it.context).load(imageUrl)
                .placeholder(R.drawable.ic_load)
                .into(imageView)
    }
}