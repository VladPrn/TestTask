package edu.vladprn.mvp.screen.main.presentation.view

import com.arellomobile.mvp.MvpView
import edu.vladprn.mvp.screen.main.domain.model.CardModel
import edu.vladprn.mvp.screen.main.domain.model.InvoiceModel

interface MainView : MvpView {
    fun onLoadInvoices(invoices: List<InvoiceModel>)
    fun onLoadCards(cards: List<CardModel>)
    fun showError(error: Int)
}