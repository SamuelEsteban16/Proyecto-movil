package com.example.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class CreateAccountFragment : Fragment() {
    private lateinit var volver: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_creacion_perfil, container, false)
        volver = view.findViewById(R.id.btn_volver)
        volver.setOnClickListener {
            Toast.makeText(requireContext(), "volviendo a home", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_login)
        }
        return view
    }
}