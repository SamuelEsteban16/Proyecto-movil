package com.example.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class PicturesFragment : Fragment() {
    private lateinit var contenidoComic: LinearLayout
    private lateinit var contenidoComicII: LinearLayout
    private lateinit var contenidoComicIII: LinearLayout

    private lateinit var contenidoVestir: LinearLayout
    private lateinit var contenidoVestirII: LinearLayout
    private lateinit var contenidoVestirIII: LinearLayout

    private lateinit var contenidoViajes: LinearLayout

    private lateinit var contenidoPaisajes: LinearLayout


    private lateinit var categoria: Button
    private lateinit var Perfil: Button
    private lateinit var Cerrar: Button
    private lateinit var Tipo: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragments_colection_fotos, container, false)
        val drawerLayout = view.findViewById<DrawerLayout>(R.id.drawer_layout)
        val menuIcon = view.findViewById<ImageView>(R.id.menu_icon)
        categoria = view.findViewById(R.id.btn_hom)
        Perfil = view.findViewById(R.id.btn_perfi)
        Cerrar = view.findViewById(R.id.btn_sali)
        Tipo=view.findViewById(R.id.btn_tip)
        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
            categoria.setOnClickListener {
                Toast.makeText(requireContext(), "Llendo a categoria", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_catego)
            }
            Tipo.setOnClickListener {
                Toast.makeText(requireContext(), "Llendo a Tipo", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_ty)
            }
            Perfil.setOnClickListener {
                Toast.makeText(requireContext(), "Llendo a Perfil", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_crearC)
            }
            Cerrar.setOnClickListener {
                Toast.makeText(requireContext(), "Cerrar sesion", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_cerr)
            }

        }
        val categoriaId = arguments?.getString("categoria_id")
        Toast.makeText(requireContext(), "Categoría: $categoriaId", Toast.LENGTH_SHORT).show()

        contenidoComic = view.findViewById(R.id.contenedorComic)
        contenidoComicII = view.findViewById(R.id.contenedorComic2)
        contenidoComicIII = view.findViewById(R.id.contenedorComic3)

        contenidoVestir= view.findViewById(R.id.contenedorVestir)
        contenidoVestirII= view.findViewById(R.id.contenedorVestir2)
        contenidoVestirIII= view.findViewById(R.id.contenedorVestir3)

        contenidoViajes= view.findViewById(R.id.contenedorViaje)

        contenidoPaisajes= view.findViewById(R.id.contenedorPaisaje)


        if (categoriaId == "COMICS" ) {
            contenidoComic.visibility = View.VISIBLE
            contenidoComicII.visibility = View.VISIBLE
            contenidoComicIII.visibility = View.VISIBLE
            contenidoVestir.visibility = View.GONE
            contenidoVestirII.visibility = View.GONE
            contenidoVestirIII.visibility = View.GONE
            contenidoViajes.visibility = View.GONE
            contenidoPaisajes.visibility = View.GONE
        }else if (categoriaId == "VESTIR"){
            contenidoComic.visibility = View.GONE
            contenidoComicII.visibility = View.GONE
            contenidoComicIII.visibility = View.GONE
            contenidoVestir.visibility = View.VISIBLE
            contenidoVestirII.visibility = View.VISIBLE
            contenidoVestirIII.visibility = View.VISIBLE
            contenidoViajes.visibility = View.GONE
            contenidoPaisajes.visibility = View.GONE
        }else if (categoriaId =="VIAJES"){
            contenidoComic.visibility = View.GONE
            contenidoComicII.visibility = View.GONE
            contenidoComicIII.visibility = View.GONE
            contenidoVestir.visibility = View.GONE
            contenidoVestirII.visibility = View.GONE
            contenidoVestirIII.visibility = View.GONE
            contenidoViajes.visibility = View.VISIBLE
            contenidoPaisajes.visibility = View.GONE
        }else if (categoriaId == "PAISAJES"){
            contenidoComic.visibility = View.GONE
            contenidoComicII.visibility = View.GONE
            contenidoComicIII.visibility = View.GONE
            contenidoVestir.visibility = View.GONE
            contenidoVestirII.visibility = View.GONE
            contenidoVestirIII.visibility = View.GONE
            contenidoViajes.visibility = View.GONE
            contenidoPaisajes.visibility = View.VISIBLE
        }

        return view
    }

}