package edu.vladprn.mvp.data.entity

data class Invoice(
    val id: Int,
    val name: String,
    val cards: List<Int>
)