package fr.epsi.cieldor.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.epsi.cieldor.BookModel
import fr.epsi.cieldor.MainActivity
import fr.epsi.cieldor.R

//donné au recyclerview
class BookAdapter(private val context: MainActivity, private val bookList : List<BookModel>, private val layoutId: Int) : RecyclerView.Adapter<BookAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val bookImage = view.findViewById<ImageView>(R.id.image_item)
        val bookName:TextView? = view.findViewById(R.id.name_item)
        val bookDesc:TextView? = view.findViewById(R.id.description_item)
        val likeIcon = view.findViewById<ImageView>(R.id.heart_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //mettre à jour chaque modèle
        val currentBook = bookList[position]
        //utiliser glide pour recup l'image à partir de son lien vers le composant

        Glide.with(context).load(Uri.parse(currentBook.imageUrl)).into(holder.bookImage)

        //mettre à jour le titre
        holder.bookName?.text = currentBook.title

        //mettre à jour la desc
        holder.bookDesc?.text = currentBook.author

        //vérifier si le livre est liké
        if(currentBook.liked){
            holder.likeIcon.setImageResource(R.drawable.ic_like)
        }
        else{
            holder.likeIcon.setImageResource(R.drawable.ic_empty_like)
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}