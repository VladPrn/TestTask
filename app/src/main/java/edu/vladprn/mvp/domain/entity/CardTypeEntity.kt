package edu.vladprn.mvp.domain.entity

import edu.vladprn.mvp.R

enum class CardTypeEntity(val drawable: Int) {
    CREDIT(R.drawable.ic_credit),
    DEBIT(R.drawable.ic_debut),
    UNKNOWN(-1);
}