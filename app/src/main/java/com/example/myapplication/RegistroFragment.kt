package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class RegistroFragment : Fragment() {

    private lateinit var passwordInput: EditText
    private lateinit var usuarioInput: EditText
    private lateinit var registerButton: Button
    private lateinit var crearCuenta: TextView
    private val usuarioEsperado="poli"
    private val passwordEsperada = "1234"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_registro, container, false)
        passwordInput = view.findViewById(R.id.password)
        usuarioInput= view.findViewById(R.id.username)
        crearCuenta = view.findViewById(R.id.create_account)
        crearCuenta.setOnClickListener {
            Toast.makeText(requireContext(), "Ingreso a crear cuenta", Toast.LENGTH_SHORT).show()
            Log.d("Ingreso a crear cuenta", "Ingreso a crear cuenta")
            findNavController().navigate(R.id.action_crearCuenta)
        }

        registerButton = view.findViewById(R.id.btn_register)
        registerButton.setOnClickListener {
            Log.d("RegistroFragment", "Botón presionado")
            val inputPassword = passwordInput.text.toString()
            val inputUsuario =usuarioInput.text.toString()
            if (passwordEsperada == passwordEsperada && usuarioEsperado==usuarioEsperado) {
                Toast.makeText(requireContext(), "Usuario y contrasena correcta", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_categoria)
            } else {
                Toast.makeText(requireContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}