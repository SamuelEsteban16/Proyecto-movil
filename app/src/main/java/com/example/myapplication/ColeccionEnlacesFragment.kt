package com.example.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ColeccionEnlacesFragment : Fragment() {
    private lateinit var categoria: Button
    private lateinit var Tipo: Button
    private lateinit var Perfil: Button
    private lateinit var Cerrar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragments_colection_enlaces, container, false)
        val drawerLayout = view.findViewById<DrawerLayout>(R.id.drawer_layout)
        val menuIcon = view.findViewById<ImageView>(R.id.menu_icon)
        categoria = view.findViewById(R.id.btn_home)
        Tipo = view.findViewById(R.id.btn_tipo)
        Perfil = view.findViewById(R.id.btn_perfil)
        Cerrar = view.findViewById(R.id.btn_salir)

        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
            categoria.setOnClickListener {
                Toast.makeText(requireContext(), "Llendo a categoria", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_categoria)
            }
            Tipo.setOnClickListener {
                Toast.makeText(requireContext(), "Llendo a Tipo", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_type)
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
        val categoriaId = arguments?.getString("categoria_id")
        Toast.makeText(requireContext(), "Categoría: $categoriaId", Toast.LENGTH_SHORT).show()

        return view
    }
}