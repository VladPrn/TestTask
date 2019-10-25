package edu.vladprn.mvp.data.repository.invoice

import edu.vladprn.mvp.data.entity.Invoice
import io.reactivex.Single
import javax.inject.Inject

interface InvoiceRepository {
    fun getInvoices(): Single<List<Invoice>>
}