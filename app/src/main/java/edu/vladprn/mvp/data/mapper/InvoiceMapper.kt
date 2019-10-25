package edu.vladprn.mvp.data.mapper

import edu.vladprn.mvp.data.model.Invoice
import edu.vladprn.mvp.domain.entity.InvoiceEntity
import javax.inject.Inject

class InvoiceMapper @Inject constructor() {
    fun mapToEntity(invoice: Invoice) =
        InvoiceEntity(
            id = invoice.id,
            name = invoice.name,
            cards = invoice.cards
        )

    fun mapToEntities(invoices: List<Invoice>) =
        invoices.map { mapToEntity(it) }
}