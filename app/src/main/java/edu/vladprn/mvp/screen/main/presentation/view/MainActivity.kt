package edu.vladprn.mvp.screen.main.presentation.view

import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import edu.vladprn.mvp.R
import edu.vladprn.mvp.data.moduls.MainModule
import edu.vladprn.mvp.screen.main.adapter.CardsAdapter
import edu.vladprn.mvp.screen.main.adapter.InvoicesAdapter
import edu.vladprn.mvp.screen.main.domain.model.CardModel
import edu.vladprn.mvp.screen.main.domain.model.InvoiceModel
import edu.vladprn.mvp.screen.main.presentation.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import toothpick.Toothpick
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView, InvoicesAdapter.ClickListener {

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick
            .openScope("MainActivity")
            .installModules(MainModule())
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onLoadInvoices(invoices: List<InvoiceModel>) {
        rvInvoices.adapter = InvoicesAdapter(invoices, this)
    }

    override fun onInvoiceClick(item: InvoiceModel) {
        presenter.onInvoiceClick(item)
    }

    override fun onLoadCards(cards: List<CardModel>) {
        rvCards.adapter = CardsAdapter(cards)
    }

    override fun showError(error: Int) =
        Toast
            .makeText(baseContext, error, Toast.LENGTH_SHORT)
            .show()
}
