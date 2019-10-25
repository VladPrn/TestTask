package edu.vladprn.mvp.data.repository.invoice

import edu.vladprn.mvp.data.entity.Invoice
import io.reactivex.Single
import javax.inject.Inject

class InvoiceRepositoryImpl @Inject constructor() : InvoiceRepository {
    override fun getInvoices(): Single<List<Invoice>> =
        Single.just(
            listOf(
                Invoice(0, "Первый счет", listOf(0)),
                Invoice(1, "Второй счет", listOf(1, 2)),
                Invoice(2, "Третий счет", listOf(2, 3, 4))
            )
        )
}