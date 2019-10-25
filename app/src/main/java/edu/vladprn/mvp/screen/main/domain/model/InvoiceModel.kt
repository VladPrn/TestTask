package edu.vladprn.mvp.screen.main.domain.model

data class InvoiceModel(
    val id: Int,
    val name: String,
    val cards: List<Int>
)