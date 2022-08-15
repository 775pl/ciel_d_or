package fr.epsi.cieldor

class BookModel(
    val author: String = "Demitria Lunetta",
    val description: String = "Petite descrition",
    val imageUrl: String = "https://images-eu.ssl-images-amazon.com/images/I/51tGiznW48L._SY291_BO1,204,203,200_QL40_ML2_.jpg",
    var liked: Boolean = false,
    val nbrPage: Int = 350,
    val title: String = "In The After"

)