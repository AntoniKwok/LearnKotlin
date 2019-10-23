package com.britney.lavenda.digitalentproject.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.britney.lavenda.digitalentproject.R
import com.britney.lavenda.digitalentproject.model.Book
import com.britney.lavenda.digitalentproject.utils.OnItemClickCallback
import com.britney.lavenda.digitalentproject.view.activity.DetailActivity
import com.bumptech.glide.Glide

class ListBookAdapter(context: Context, private val listBooks: ArrayList<Book>) :
    RecyclerView.Adapter<ListBookAdapter.BookViewHolder>() {
    private val context: Context
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.listbook, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBooks.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val (title, writer, language, price, synopsis, photo) = listBooks[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .placeholder(R.drawable.ic_eclipse_1s_200px)
            .into(holder.imgPhoto)
        holder.title.text = title
        holder.writer.text = writer
        holder.price.text = price
//        holder.itemView.setOnClickListener {
//            onItemClickCallback.onItemClicked(listBooks[holder.adapterPosition])
//            val moveIntent = Intent(context, DetailActivity::class.java)
//            moveIntent.putExtra(DetailActivity.EXTRA_BOOK,)
//            startActivity(moveIntent)
//        }
    }


    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.bookImageView)
        var title: TextView = itemView.findViewById(R.id.textTitle)
        var writer: TextView = itemView.findViewById(R.id.textWriter)
        var price: TextView = itemView.findViewById(R.id.textPrice)
    }

}
