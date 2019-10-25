package edu.vladprn.mvp.presentation.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.vladprn.mvp.R
import edu.vladprn.mvp.domain.entity.InvoiceEntity
import kotlinx.android.synthetic.main.item_invoice.view.*

class InvoicesAdapter(
    private val items: List<InvoiceEntity>,
    private val listener: ClickListener
) : RecyclerView.Adapter<InvoicesAdapter.InvoicesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvoicesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_invoice, parent, false)
        return InvoicesViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: InvoicesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class InvoicesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(invoice: InvoiceEntity) {
            itemView.apply {
                text.text = invoice.name
                setOnClickListener { listener.onInvoiceClick(invoice) }
            }
        }
    }

    interface ClickListener {
        fun onInvoiceClick(item: InvoiceEntity)
    }
}