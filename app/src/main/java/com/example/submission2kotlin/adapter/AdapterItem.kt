package com.example.submission2kotlin.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission2kotlin.ListUI
import com.example.submission2kotlin.model.Item
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class AdapterItem(
    private val context: Context,
    private val items: List<Item>,
    private val listener: (Item) -> Unit
) :
    RecyclerView.Adapter<AdapterItem.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ListUI().createView(
            AnkoContext.Companion.create(context)
        )
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(container: View) : RecyclerView.ViewHolder(container) {
        fun bindItem(items: Item, listener: (Item) -> Unit) {
            val name = itemView.find<TextView>(ListUI.name)
            val img = itemView.find<ImageView>(ListUI.image)

            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(img)

            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}