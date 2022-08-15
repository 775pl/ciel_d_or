package fr.epsi.cieldor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.epsi.cieldor.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = BookRepository() //on initie le repositiory

        //mettre à jour la liste
        repo.updateData{
            //une fois chargé, on met le fragment
            //injection du fragment dans fragment_container
            val transaction = supportFragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, HomeFragment(this));
            transaction.addToBackStack(null)//pas de retour
            transaction.commit()//envoyé
        }


    }
}