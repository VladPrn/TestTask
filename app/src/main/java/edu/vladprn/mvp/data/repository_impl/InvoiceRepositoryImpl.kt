package edu.vladprn.mvp.data.repository_impl

import edu.vladprn.mvp.data.mapper.InvoiceMapper
import edu.vladprn.mvp.data.model.Invoice
import edu.vladprn.mvp.domain.entity.InvoiceEntity
import edu.vladprn.mvp.domain.repository.InvoiceRepository
import io.reactivex.Single
import javax.inject.Inject

class InvoiceRepositoryImpl @Inject constructor(
    private val mapper: InvoiceMapper
) :
    InvoiceRepository {
    override fun getInvoices(): Single<List<InvoiceEntity>> =
        Single.just(
            listOf(
                Invoice(0, "Первый счет", listOf(0)),
                Invoice(1, "Второй счет", listOf(1, 2)),
                Invoice(2, "Третий счет", listOf(2, 3, 4))
            )
        )
            .map { mapper.mapToEntities(it) }
}