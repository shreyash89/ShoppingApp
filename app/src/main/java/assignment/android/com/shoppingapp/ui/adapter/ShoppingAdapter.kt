/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 3:38 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 30/3/20 3:38 PM
 *
 */

package assignment.android.com.shoppingapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import assignment.android.com.shoppingapp.R
import assignment.android.com.shoppingapp.data.model.Product
import assignment.android.com.shoppingapp.data.utils.AppUtils
import assignment.android.com.shoppingapp.databinding.ItemViewBinding


class ShoppingAdapter(val context: Context, var product: List<Product>?, var selectedCurrency: String) :
    RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {

        val itemViewBinding: ItemViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.item_view, parent, false
        )
        return ShoppingViewHolder(itemViewBinding.root)
    }

    override fun getItemCount(): Int {
        return product!!.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val productInfo: Product = product!![position]
        holder.itemViewBinding?.product = productInfo

        holder.itemViewBinding?.tvPrice?.text = ""
        if(productInfo.currency != selectedCurrency){
            var rate = AppUtils.getRate(productInfo.currency, selectedCurrency)

            if(rate == (-1).toDouble()){
                holder.itemViewBinding?.tvPrice?.text = "NA"
                return
            }

            var price = (productInfo.price.toDouble() * rate)
            holder.itemViewBinding?.tvPrice?.text = String.format("%.2f ", price)
        }else{
            holder.itemViewBinding?.tvPrice?.text = productInfo.price
        }


        var price = when(selectedCurrency){
            "INR" -> "Rs ${holder.itemViewBinding?.tvPrice?.text}"
            "AED" -> "AED ${holder.itemViewBinding?.tvPrice?.text}"
            "SAR" -> "SAR ${holder.itemViewBinding?.tvPrice?.text}"
            else ->{
                "NA"
            }
        }
        holder.itemViewBinding?.tvPrice?.text = price
    }

    class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemViewBinding = DataBindingUtil.bind<ItemViewBinding>(itemView)
    }

    fun selectCurrency(currency: String){
        this.selectedCurrency = currency
        notifyDataSetChanged()
    }

}
