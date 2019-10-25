package edu.vladprn.mvp.data.moduls

import edu.vladprn.mvp.data.repository.card.CardRepository
import edu.vladprn.mvp.data.repository.card.CardRepositoryImpl
import edu.vladprn.mvp.data.repository.invoice.InvoiceRepository
import edu.vladprn.mvp.data.repository.invoice.InvoiceRepositoryImpl
import edu.vladprn.mvp.screen.main.domain.interactor.MainInteractor
import edu.vladprn.mvp.screen.main.presentation.presenter.MainPresenter
import toothpick.config.Module

class MainModule : Module() {
    init {
        bind(CardRepository::class.java)
            .to(CardRepositoryImpl::class.java)
        bind(InvoiceRepository::class.java)
            .to(InvoiceRepositoryImpl::class.java)
        bind(MainPresenter::class.java)
        bind(MainInteractor::class.java)
    }
}