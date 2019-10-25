package edu.vladprn.mvp.data.mapper

import edu.vladprn.mvp.data.entity.Card
import edu.vladprn.mvp.screen.main.domain.model.CardModel
import edu.vladprn.mvp.screen.main.domain.model.CardType

fun Card.toModel() =
    CardModel(
        id = id,
        name = name,
        type = CardType.fromServerInt(category)
    )

fun List<Card>.toModels() =
    map { it.toModel() }