package com.hsdesigns.caramelwallet.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hsdesigns.caramelwallet.R
import com.hsdesigns.caramelwallet.databinding.ItemsListRecyclerviewItemsBinding
import com.hsdesigns.caramelwallet.ui.model.ListOfItemsDto
import com.hsdesigns.caramelwallet.utils.BuyItemClickListenerInterface

class ListItemRecyclerViewAdapter(private val listOfItems: List<ListOfItemsDto>, val clickListener: BuyItemClickListenerInterface) : RecyclerView.Adapter<ListItemRecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view)  {
        private val binding: ItemsListRecyclerviewItemsBinding = ItemsListRecyclerviewItemsBinding.bind(view)
        init {
            buyItemClickListener()
        }
        fun bindViews(listOfItems: ListOfItemsDto){
            binding.idNumberTextTv.text = listOfItems.id
            binding.productNameTextTv.text = listOfItems.name
            binding.amountNameTextTv.text = listOfItems.amount
        }
         private fun buyItemClickListener(){
            binding.fragmentWelcomeRegisterBtn.setOnClickListener {
                clickListener.buyItemClickListener(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.items_list_recyclerview_items, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(listOfItems[position])
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }
}