package edu.vladprn.mvp.presentation.main.view

import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import edu.vladprn.mvp.R
import edu.vladprn.mvp.data.di.MainModule
import edu.vladprn.mvp.presentation.main.adapter.CardsAdapter
import edu.vladprn.mvp.presentation.main.adapter.InvoicesAdapter
import edu.vladprn.mvp.domain.entity.CardEntity
import edu.vladprn.mvp.domain.entity.InvoiceEntity
import edu.vladprn.mvp.presentation.main.presenter.MainPresenter
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

    override fun onLoadInvoices(invoices: List<InvoiceEntity>) {
        rvInvoices.adapter = InvoicesAdapter(invoices, this)
    }

    override fun onInvoiceClick(item: InvoiceEntity) {
        presenter.onInvoiceClick(item)
    }

    override fun onLoadCards(cards: List<CardEntity>) {
        rvCards.adapter = CardsAdapter(cards)
    }

    override fun showError(error: Int) =
        Toast
            .makeText(baseContext, error, Toast.LENGTH_SHORT)
            .show()
}
