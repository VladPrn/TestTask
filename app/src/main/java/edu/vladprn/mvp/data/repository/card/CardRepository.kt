package edu.vladprn.mvp.data.repository.card

import edu.vladprn.mvp.data.entity.Card
import io.reactivex.Single

interface CardRepository {
    fun getCards(): Single<List<Card>>
    fun getCardById(id: Int): Single<Card>
}