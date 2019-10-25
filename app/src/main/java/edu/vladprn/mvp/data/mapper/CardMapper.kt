package edu.vladprn.mvp.data.mapper

import edu.vladprn.mvp.data.model.Card
import edu.vladprn.mvp.domain.entity.CardEntity
import edu.vladprn.mvp.domain.entity.CardTypeEntity
import javax.inject.Inject

class CardMapper @Inject constructor() {
    fun mapToEntity(card: Card) =
        CardEntity(
            id = card.id,
            name = card.name,
            type = mapServerIntToType(card.category)
        )

    fun mapToEntities(cards: List<Card>) =
        cards.map { mapToEntity(it) }

    private fun mapServerIntToType(value: Int) =
        when (value) {
            0 -> CardTypeEntity.CREDIT
            1 -> CardTypeEntity.DEBIT
            else -> CardTypeEntity.UNKNOWN
        }
}