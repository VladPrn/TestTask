package edu.vladprn.mvp.domain.repository

import edu.vladprn.mvp.domain.entity.CardEntity
import io.reactivex.Single

interface CardRepository {
    fun getCards(): Single<List<CardEntity>>
}