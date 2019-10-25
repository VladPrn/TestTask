package edu.vladprn.mvp.presentation.main.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import edu.vladprn.mvp.R
import edu.vladprn.mvp.domain.entity.InvoiceEntity
import edu.vladprn.mvp.domain.interactor.CardInteractor
import edu.vladprn.mvp.domain.interactor.InvoiceInteractor
import edu.vladprn.mvp.presentation.main.view.MainView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val invoiceInteractor: InvoiceInteractor,
    private val cardInteractor: CardInteractor
) : MvpPresenter<MainView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getInvoices()
    }

    fun getInvoices() {
        invoiceInteractor.getInvoices()
            .subscribe({
                viewState.onLoadInvoices(it)
                if (it.isNotEmpty()) {
                    onInvoiceClick(it.first())
                }
            }, {
                viewState.showError(R.string.error)
            })
            .let { compositeDisposable.add(it) }
    }

    fun onInvoiceClick(invoice: InvoiceEntity) {
        cardInteractor.getCardsByInvoice(invoice)
            .subscribe(viewState::onLoadCards) {
                viewState.showError(R.string.error)
            }
            .let { compositeDisposable.add(it) }

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}