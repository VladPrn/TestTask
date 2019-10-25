package edu.vladprn.mvp.data.model

data class Invoice(
    val id: Int,
    val name: String,
    val cards: List<Int>
)