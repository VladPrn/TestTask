package edu.vladprn.mvp.screen.main.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import edu.vladprn.mvp.R
import edu.vladprn.mvp.screen.main.domain.interactor.MainInteractor
import edu.vladprn.mvp.screen.main.domain.model.InvoiceModel
import edu.vladprn.mvp.screen.main.presentation.view.MainView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val interactor: MainInteractor
) : MvpPresenter<MainView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getInvoices()
    }

    fun getInvoices() {
        interactor.getInvoices()
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

    fun onInvoiceClick(invoice: InvoiceModel) {
        interactor.getCardsByInvoice(invoice)
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