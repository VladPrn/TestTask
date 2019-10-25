package edu.vladprn.mvp.data.repository_impl

import edu.vladprn.mvp.data.mapper.CardMapper
import edu.vladprn.mvp.data.model.Card
import edu.vladprn.mvp.domain.entity.CardEntity
import edu.vladprn.mvp.domain.repository.CardRepository
import io.reactivex.Single
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val mapper: CardMapper
) : CardRepository {
    override fun getCards(): Single<List<CardEntity>> =
        Single.just(
            listOf(
                Card(0, "Первая карта", 0),
                Card(1, "Вторая карта ", 1),
                Card(2, "Третья карта ", 0),
                Card(3, "Четверта карта ", 1),
                Card(4, "Пятая карта ", 0)
            )
        )
            .map { mapper.mapToEntities(it) }
}