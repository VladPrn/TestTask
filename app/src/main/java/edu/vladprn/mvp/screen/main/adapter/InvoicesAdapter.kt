package edu.vladprn.mvp.screen.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.vladprn.mvp.R
import edu.vladprn.mvp.screen.main.domain.model.InvoiceModel
import kotlinx.android.synthetic.main.item_invoice.view.*

class InvoicesAdapter(
    private val items: List<InvoiceModel>,
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
        fun bind(invoice: InvoiceModel) {
            itemView.apply {
                text.text = invoice.name
                setOnClickListener { listener.onInvoiceClick(invoice) }
            }
        }
    }

    interface ClickListener {
        fun onInvoiceClick(item: InvoiceModel)
    }
}