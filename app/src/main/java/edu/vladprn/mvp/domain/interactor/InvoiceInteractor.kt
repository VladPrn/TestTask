package edu.vladprn.mvp.domain.interactor

import edu.vladprn.mvp.domain.entity.InvoiceEntity
import edu.vladprn.mvp.domain.repository.InvoiceRepository
import io.reactivex.Single
import javax.inject.Inject

class InvoiceInteractor @Inject constructor(
    private val invoiceRepository: InvoiceRepository
) {
    fun getInvoices(): Single<List<InvoiceEntity>> =
        invoiceRepository.getInvoices()
}