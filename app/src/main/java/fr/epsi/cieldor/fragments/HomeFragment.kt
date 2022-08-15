package fr.epsi.cieldor.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.cieldor.BookModel
import fr.epsi.cieldor.BookRepository.Singleton.bookList
import fr.epsi.cieldor.MainActivity
import fr.epsi.cieldor.R
import fr.epsi.cieldor.adapter.BookAdapter
import fr.epsi.cieldor.adapter.BookItemDecoration

class HomeFragment(private val context: MainActivity) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        //récup le recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = BookAdapter(context, bookList, R.layout.item_horizontal_book)

        //recup second recyclerview

        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = BookAdapter(context, bookList, R.layout.item_vertical_book)
        verticalRecyclerView.addItemDecoration(BookItemDecoration())
        return view
    }
}