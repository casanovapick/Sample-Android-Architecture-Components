package com.example.picked.draftkotlin.databinding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View


class BindingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binder: ViewDataBinding = DataBindingUtil.bind(itemView.rootView)
}