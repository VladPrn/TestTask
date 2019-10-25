package edu.vladprn.mvp.screen.main.domain.model

import edu.vladprn.mvp.R

enum class CardType(val drawable: Int) {
    CREDIT(R.drawable.ic_credit),
    DEBIT(R.drawable.ic_debut),
    UNKNOWN(-1);

    companion object {
        fun fromServerInt(value: Int) =
            when (value) {
                0 -> CREDIT
                1 -> DEBIT
                else -> UNKNOWN
            }
    }
}