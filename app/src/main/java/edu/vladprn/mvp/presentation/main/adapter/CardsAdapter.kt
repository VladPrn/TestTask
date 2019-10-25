package edu.vladprn.mvp.presentation.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.vladprn.mvp.R
import edu.vladprn.mvp.domain.entity.CardEntity
import kotlinx.android.synthetic.main.item_card.view.*

class CardsAdapter(
    private val items: List<CardEntity>
) : RecyclerView.Adapter<CardsAdapter.CardsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return CardsViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class CardsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(card: CardEntity) {
            itemView.apply {
                text.text = card.name
                icon.setBackgroundResource(card.type.drawable)
            }
        }
    }
}