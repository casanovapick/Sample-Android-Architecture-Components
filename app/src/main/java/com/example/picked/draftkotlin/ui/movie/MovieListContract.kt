package com.example.picked.draftkotlin.ui.movie

import com.example.picked.draftkotlin.mvp.MvpView

interface MovieListContract {
    interface View : MvpView {
        fun showProgress()
        fun hideProgress()
    }

    interface Action {
        fun reload()
    }
}