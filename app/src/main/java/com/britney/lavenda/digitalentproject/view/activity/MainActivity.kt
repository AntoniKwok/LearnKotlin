package com.britney.lavenda.digitalentproject.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.britney.lavenda.digitalentproject.R
import com.britney.lavenda.digitalentproject.model.Book
import com.britney.lavenda.digitalentproject.model.BookData
import com.britney.lavenda.digitalentproject.utils.OnItemClickCallback
import com.britney.lavenda.digitalentproject.view.adapter.ListBookAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var list: ArrayList<Book> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.bookRecyclerView)
        recyclerView.setHasFixedSize(true)

        list.addAll(BookData.listData)



        recyclerView.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = ListBookAdapter(this, list)

        cardViewHeroAdapter.setOnItemClickCallback(object : OnItemClickCallback{
            override fun onItemClicked(data: Book) {
                showSelectedData(data)
            }
        })

        recyclerView.adapter = cardViewHeroAdapter


    }

    private fun showSelectedData(book: Book) {
        Toast.makeText(this, "Kamu memilih " + book.title, Toast.LENGTH_SHORT).show()
        val moveIntent = Intent(this, DetailActivity::class.java)
        moveIntent.putExtra("book_data", book)
        startActivity(moveIntent)
    }

}
