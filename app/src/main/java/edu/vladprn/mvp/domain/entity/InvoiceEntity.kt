package edu.vladprn.mvp.domain.entity

data class InvoiceEntity(
    val id: Int,
    val name: String,
    val cards: List<Int>
)