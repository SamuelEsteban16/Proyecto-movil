package com.example.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class CategoriasFragment : Fragment() {
    private lateinit var btnComics: Button
    private lateinit var btnVestir: Button
    private lateinit var btnViajes: Button
    private lateinit var btnPaisajes: Button

    private lateinit var contenedor1: CardView
    private lateinit var contenedor2: CardView
    private lateinit var contenedor3: CardView

    private lateinit var contenidoComic1: LinearLayout
    private lateinit var contenidoVestir1: LinearLayout
    private lateinit var contenidoViajes1: LinearLayout
    private lateinit var contenidoPaisajes1: LinearLayout

    private lateinit var contenidoComic2: LinearLayout
    private lateinit var contenidoVestir2: LinearLayout
    private lateinit var contenidoPaisajes2: LinearLayout

    private lateinit var contenidoComic3: LinearLayout
    private lateinit var contenidoVestir3: LinearLayout
    private lateinit var contenidoViajes3: LinearLayout
    private lateinit var contenidoPaisajes3: LinearLayout

    private lateinit var categoria: Button
    private lateinit var Perfil: Button
    private lateinit var Cerrar: Button

    private var categoriaSeleccionada: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_categorias, container, false)
        val drawerLayout = view.findViewById<DrawerLayout>(R.id.drawer_layout)
        val menuIcon = view.findViewById<ImageView>(R.id.menu_icon)
        categoria = view.findViewById(R.id.btn_home)
        Perfil = view.findViewById(R.id.btn_perfil)
        Cerrar = view.findViewById(R.id.btn_salir)

        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
            categoria.setOnClickListener {
                Toast.makeText(requireContext(), "Esta en categoria", Toast.LENGTH_SHORT).show()
            }
            Perfil.setOnClickListener {
                Toast.makeText(requireContext(), "Llendo a Perfil", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_crearCuenta)
            }
            Cerrar.setOnClickListener {
                Toast.makeText(requireContext(), "Cerrar sesion", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_cerrar)
            }

        }

        val corazon1 = view.findViewById<ImageView>(R.id.corazon1)
        corazon1.setOnClickListener {
            categoriaSeleccionada?.let { categoria ->
                val bundle = Bundle().apply {
                    putString("categoria_id", categoria)
                }
                findNavController().navigate(R.id.action_type, bundle)
            } ?: Toast.makeText(requireContext(), "Selecciona una categoría primero", Toast.LENGTH_SHORT).show()
        }

        val corazon2 = view.findViewById<ImageView>(R.id.corazon2)
        corazon2.setOnClickListener {
            categoriaSeleccionada?.let { categoria ->
                val bundle = Bundle().apply {
                    putString("categoria_id", categoria)
                }
                findNavController().navigate(R.id.action_type, bundle)
            } ?: Toast.makeText(requireContext(), "Selecciona una categoría primero", Toast.LENGTH_SHORT).show()
        }

        val corazon3 = view.findViewById<ImageView>(R.id.corazon3)
        corazon3.setOnClickListener {
            categoriaSeleccionada?.let { categoria ->
                val bundle = Bundle().apply {
                    putString("categoria_id", categoria)
                }
                findNavController().navigate(R.id.action_type, bundle)
            } ?: Toast.makeText(requireContext(), "Selecciona una categoría primero", Toast.LENGTH_SHORT).show()
        }

        btnComics = view.findViewById(R.id.btn_comics)
        btnVestir = view.findViewById(R.id.btn_vestir)
        btnViajes = view.findViewById(R.id.btn_viajes)
        btnPaisajes = view.findViewById(R.id.btn_paisajes)

        val botones = listOf(btnComics, btnVestir, btnViajes, btnPaisajes)

        contenedor1 = view.findViewById(R.id.contenedor1)
        contenedor2 = view.findViewById(R.id.contenedor2)
        contenedor3 = view.findViewById(R.id.contenedor3)

        contenidoComic1 = view.findViewById(R.id.contenidoComic1)
        contenidoComic2 = view.findViewById(R.id.contenidoComic2)
        contenidoComic3 = view.findViewById(R.id.contenidoComic3)

        contenidoVestir1 = view.findViewById(R.id.contenidoVestir1)
        contenidoVestir2 = view.findViewById(R.id.contenidoVestir2)
        contenidoVestir3 = view.findViewById(R.id.contenidoVestir3)

        contenidoViajes1 = view.findViewById(R.id.contenidoViajes1)
        contenidoViajes3 = view.findViewById(R.id.contenidoViajes3)

        contenidoPaisajes1 = view.findViewById(R.id.contenidoPaisajes1)
        contenidoPaisajes2 = view.findViewById(R.id.contenidoPaisajes2)
        contenidoPaisajes3 = view.findViewById(R.id.contenidoPaisajes3)



        val todosContenidos = listOf(
            contenidoComic1, contenidoComic2, contenidoComic3,
            contenidoVestir1, contenidoVestir2, contenidoVestir3,
            contenidoViajes1, contenidoViajes3,
            contenidoPaisajes1, contenidoPaisajes2, contenidoPaisajes3,
            contenedor1, contenedor2, contenedor3
        )
        todosContenidos.forEach { it.visibility = View.GONE }
        botones.forEach { it.setBackgroundResource(R.drawable.btn_deseleccion) }

        botones.forEach { boton ->
            boton.setOnClickListener {
                botones.forEach { it.setBackgroundResource(R.drawable.btn_deseleccion) }
                boton.setBackgroundResource(R.drawable.btn_seleccion)

                when (boton.id) {
                    R.id.btn_comics -> {
                        categoriaSeleccionada = "COMICS"
                        mostrarContenido("COMICS")
                    }
                    R.id.btn_vestir -> {
                        categoriaSeleccionada = "VESTIR"
                        mostrarContenido("VESTIR")
                    }
                    R.id.btn_viajes -> {
                        categoriaSeleccionada = "VIAJES"
                        mostrarContenido("VIAJES")
                    }
                    R.id.btn_paisajes -> {
                        categoriaSeleccionada = "PAISAJES"
                        mostrarContenido("PAISAJES")
                    }
                }
            }
        }

        return view
    }

    private fun mostrarContenido(categoria: String) {
        val todosContenidos = listOf(
            contenidoComic1, contenidoComic2, contenidoComic3,
            contenidoVestir1, contenidoVestir2, contenidoVestir3,
            contenidoViajes1, contenidoViajes3,
            contenidoPaisajes1, contenidoPaisajes2, contenidoPaisajes3
        )
        todosContenidos.forEach { it.visibility = View.GONE }

        when (categoria) {
            "COMICS" -> {
                contenidoComic1.visibility = View.VISIBLE
                contenidoComic2.visibility = View.VISIBLE
                contenidoComic3.visibility = View.VISIBLE
                contenedor1.visibility = View.VISIBLE
                contenedor2.visibility = View.VISIBLE
                contenedor3.visibility = View.VISIBLE
            }
            "VESTIR" -> {
                contenidoVestir1.visibility = View.VISIBLE
                contenidoVestir2.visibility = View.VISIBLE
                contenidoVestir3.visibility = View.VISIBLE
                contenedor1.visibility = View.VISIBLE
                contenedor2.visibility = View.VISIBLE
                contenedor3.visibility = View.VISIBLE
            }
            "VIAJES" -> {
                contenidoViajes1.visibility = View.VISIBLE
                contenidoViajes3.visibility = View.VISIBLE
                contenedor1.visibility = View.VISIBLE
                contenedor2.visibility = View.VISIBLE
                contenedor3.visibility = View.VISIBLE
            }
            "PAISAJES" -> {
                contenidoPaisajes1.visibility = View.VISIBLE
                contenidoPaisajes2.visibility = View.VISIBLE
                contenidoPaisajes3.visibility = View.VISIBLE
                contenedor1.visibility = View.VISIBLE
                contenedor2.visibility = View.VISIBLE
                contenedor3.visibility = View.VISIBLE
            }
        }
    }
}