package edu.vladprn.mvp.data.mapper

import edu.vladprn.mvp.data.entity.Invoice
import edu.vladprn.mvp.screen.main.domain.model.InvoiceModel

fun Invoice.toModel() =
    InvoiceModel(
        id = id,
        name = name,
        cards = cards
    )

fun List<Invoice>.toModels() =
    map { it.toModel() }