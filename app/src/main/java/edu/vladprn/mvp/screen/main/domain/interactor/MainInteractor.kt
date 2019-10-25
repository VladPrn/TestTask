package edu.vladprn.mvp.screen.main.domain.interactor

import edu.vladprn.mvp.data.mapper.toModel
import edu.vladprn.mvp.data.mapper.toModels
import edu.vladprn.mvp.data.repository.card.CardRepository
import edu.vladprn.mvp.data.repository.invoice.InvoiceRepository
import edu.vladprn.mvp.screen.main.domain.model.CardModel
import edu.vladprn.mvp.screen.main.domain.model.InvoiceModel
import io.reactivex.Single
import javax.inject.Inject

class MainInteractor @Inject constructor(
    private val invoiceRepository: InvoiceRepository,
    private val cardRepository: CardRepository
) {
    fun getInvoices(): Single<List<InvoiceModel>> =
        invoiceRepository.getInvoices()
            .map { it.toModels() }

    fun getCardsByInvoice(invoice: InvoiceModel): Single<List<CardModel>> =
        Single.just(invoice.cards)
            .flattenAsFlowable { it }
            .flatMap { cardId ->
                cardRepository
                    .getCardById(cardId)
                    .map { it.toModel() }
                    .toFlowable()
            }
            .toList()
}