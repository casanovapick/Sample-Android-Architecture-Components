package com.example.picked.draftkotlin.data

data class Movie(
        val image: String? = null,
        val rating: Double? = null,
        val genre: List<String?>? = null,
        val title: String? = null,
        val releaseYear: Int? = null
) {
    val genreText: String
        get() {
            return genre?.joinToString(",") ?: ""
        }
}

fun Movie.displayGenre(): String {
    return genre?.joinToString(",") ?: ""
}