package com.hsdesigns.caramelwallet.feature_dashboard.ui.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hsdesigns.caramelwallet.R
import com.hsdesigns.caramelwallet.databinding.ItemsListRecyclerviewItemsBinding
import com.hsdesigns.caramelwallet.feature_dashboard.data.remote.dto.ProductsDto

class ListItemAdapter(private val listOfItems: List<ProductsDto>, val context: Context) : RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view)  {
        private val binding: ItemsListRecyclerviewItemsBinding = ItemsListRecyclerviewItemsBinding.bind(view)
        var btn = binding.fragmentBuyNowBtn
        init {
            buyItemClickListener()
        }
        fun bindViews(products: ProductsDto){
            binding.idNumberTextTv.text = products.id
            binding.productNameTextTv.text = products.name
            binding.amountNameTextTv.text = products.amount.toString()
        }
         private fun buyItemClickListener(){
            binding.fragmentBuyNowBtn.setOnClickListener {
                Log.d("TAG", "buyItemClickListener: ")
//                clickListener.buyItemClickListener(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.items_list_recyclerview_items, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(listOfItems[position])
        holder.btn.setOnClickListener {
            Toast.makeText(context, listOfItems[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }
}