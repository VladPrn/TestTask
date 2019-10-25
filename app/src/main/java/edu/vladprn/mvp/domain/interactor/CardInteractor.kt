package edu.vladprn.mvp.domain.interactor

import edu.vladprn.mvp.domain.entity.CardEntity
import edu.vladprn.mvp.domain.entity.InvoiceEntity
import edu.vladprn.mvp.domain.repository.CardRepository
import io.reactivex.Single
import javax.inject.Inject

class CardInteractor @Inject constructor(
    private val cardRepository: CardRepository
) {
    fun getCardsByInvoice(invoice: InvoiceEntity): Single<List<CardEntity>> =
        Single.just(invoice.cards)
            .flattenAsFlowable { it }
            .flatMap { cardId ->
                getCardById(cardId).toFlowable()
            }
            .toList()

    private fun getCardById(id: Int): Single<CardEntity> =
        cardRepository.getCards()
            .flattenAsFlowable { it }
            .filter { it.id == id }
            .firstOrError()
}