package com.example.presentation.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.catsapp.presentation.R
import com.example.catsapp.presentation.databinding.CatsItemListBinding
import com.example.entities.Cat

class CatsAdapterList(
    private val listener: CatsAdapterListListener
) :
    ListAdapter<Cat, CatsAdapterList.ViewHolder>(CatsAdapterListDiffCallback()) {

    interface CatsAdapterListListener {
        fun onClickDetail(cats: Cat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cats_item_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.setUi(item, listener)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CatsItemListBinding.bind(itemView)

        fun setUi(
            catsList: Cat,
            listener: CatsAdapterListListener
        ) {
            val context = binding.root.context
            binding.catName.text = catsList.name
            binding.temperament.text = catsList.temperament
            binding.origin.text = catsList.origin
            binding.adaptability.text = catsList.adaptability.toString()
            binding.energyLevel.text = catsList.energy_level.toString()
            binding.intelligence.text = catsList.intelligence.toString()
            binding.description.text = catsList.description

            binding.clCardCat.setOnClickListener {
                listener.onClickDetail(catsList)
            }
        }
    }
}

class CatsAdapterListDiffCallback : DiffUtil.ItemCallback<Cat>() {
    override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem == newItem
    }
}
