package edu.vladprn.mvp.domain.entity

data class CardEntity(
    val id: Int,
    val name: String,
    val type: CardTypeEntity
)