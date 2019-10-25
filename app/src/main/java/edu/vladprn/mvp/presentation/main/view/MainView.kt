package edu.vladprn.mvp.presentation.main.view

import com.arellomobile.mvp.MvpView
import edu.vladprn.mvp.domain.entity.CardEntity
import edu.vladprn.mvp.domain.entity.InvoiceEntity

interface MainView : MvpView {
    fun onLoadInvoices(invoices: List<InvoiceEntity>)
    fun onLoadCards(cards: List<CardEntity>)
    fun showError(error: Int)
}