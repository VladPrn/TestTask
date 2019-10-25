package edu.vladprn.mvp.data.di

import edu.vladprn.mvp.data.mapper.CardMapper
import edu.vladprn.mvp.data.mapper.InvoiceMapper
import edu.vladprn.mvp.domain.repository.CardRepository
import edu.vladprn.mvp.data.repository_impl.CardRepositoryImpl
import edu.vladprn.mvp.domain.repository.InvoiceRepository
import edu.vladprn.mvp.data.repository_impl.InvoiceRepositoryImpl
import edu.vladprn.mvp.domain.interactor.InvoiceInteractor
import edu.vladprn.mvp.presentation.main.presenter.MainPresenter
import toothpick.config.Module

class MainModule : Module() {
    init {
        bind(CardMapper::class.java)
        bind(InvoiceMapper::class.java)
        bind(CardRepository::class.java)
            .to(CardRepositoryImpl::class.java)
        bind(InvoiceRepository::class.java)
            .to(InvoiceRepositoryImpl::class.java)
        bind(MainPresenter::class.java)
        bind(InvoiceInteractor::class.java)
    }
}