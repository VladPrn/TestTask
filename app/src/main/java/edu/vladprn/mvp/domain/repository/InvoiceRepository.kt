package edu.vladprn.mvp.domain.repository

import edu.vladprn.mvp.domain.entity.InvoiceEntity
import io.reactivex.Single

interface InvoiceRepository {
    fun getInvoices(): Single<List<InvoiceEntity>>
}