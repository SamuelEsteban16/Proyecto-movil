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

class TypeFragment : Fragment() {

    private lateinit var categoria: Button
    private lateinit var Tipo: Button
    private lateinit var Perfil: Button
    private lateinit var Cerrar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_type, container, false)
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
                Toast.makeText(requireContext(), "Esta en Tipo", Toast.LENGTH_SHORT).show()
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

        val corazon1 = view.findViewById<ImageView>(R.id.corazon1)
        corazon1.setOnClickListener {
            categoriaId?.let { categoria ->
                val bundle = Bundle().apply {
                    putString("categoria_id", categoria)
                }
                findNavController().navigate(R.id.action_fotos,bundle)
            } ?: Toast.makeText(requireContext(), "Selecciona una categoría primero", Toast.LENGTH_SHORT).show()
        }

        val corazon2 = view.findViewById<ImageView>(R.id.corazon2)
        corazon2.setOnClickListener {
            categoriaId?.let { categoria ->
                val bundle = Bundle().apply {
                    putString("categoria_id", categoria)
                }

            } ?: Toast.makeText(requireContext(), "Selecciona una categoría primero", Toast.LENGTH_SHORT).show()
        }

        val corazon3 = view.findViewById<ImageView>(R.id.corazon3)
        corazon3.setOnClickListener {
            categoriaId?.let { categoria ->
                val bundle = Bundle().apply {
                    putString("categoria_id", categoria)
                }
                findNavController().navigate(R.id.action_enlace,bundle)
            } ?: Toast.makeText(requireContext(), "Selecciona una categoría primero", Toast.LENGTH_SHORT).show()
        }

        return view
    }

}