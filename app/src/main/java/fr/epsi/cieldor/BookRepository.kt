package fr.epsi.cieldor

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import fr.epsi.cieldor.BookRepository.Singleton.bookList
import fr.epsi.cieldor.BookRepository.Singleton.myRef

class BookRepository {
    //interaction avec la bdd

    object Singleton {
        //se connecter à "books"
        //val database_ref = FirebaseDatabase.getInstance().getReference("books")
        val database = Firebase.database
        val myRef = database.getReference("books")


        //liste qui contient les livres
        val bookList = arrayListOf<BookModel>()
    }

    fun updateData(callback: () -> Unit){
        //absorbe les données depuis la database_ref -> booklist
        myRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                //retirer les anciens livres
                bookList.clear()
                // on récupe les données récoltées sous la forme d'une liste
                for (datasnapshot in snapshot.children){
                    //construction d'un objet book
                    val book = snapshot.getValue(BookModel::class.java)
                    //vérifier si le livre != null
                    if(book != null){
                        //on add le livre à la liste
                        bookList.add(book)
                    }
                }
                //actionner le callback
                callback()
            }

            override fun onCancelled(snapshot: DatabaseError) {
                // au cas où rien n'est trouvé
            }

        })

    }
}