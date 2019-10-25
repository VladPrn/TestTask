package edu.vladprn.mvp.data.repository.card

import edu.vladprn.mvp.data.entity.Card
import io.reactivex.Single
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor() : CardRepository {
    override fun getCards(): Single<List<Card>> =
        Single.just(
            listOf(
                Card(0, "Первая карта", 0),
                Card(1, "Вторая карта ", 1),
                Card(2, "Третья карта ", 0),
                Card(3, "Четверта карта ", 1),
                Card(4, "Пятая карта ", 0)
            )
        )

    override fun getCardById(id: Int): Single<Card> =
        getCards()
            .flattenAsFlowable { it }
            .filter { it.id == id }
            .firstOrError()
}