package com.example.shopbarber.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopbarber.R
import com.example.shopbarber.adapter.ServicosAdapter
import com.example.shopbarber.databinding.ActivityHomeBinding
import com.example.shopbarber.model.Servico

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicosAdapter : ServicosAdapter
    private val listaServicos: MutableList<Servico> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome")

        binding.txtNomeUsuario.text = "Bem vindo(a), $nome"
        val recyclerViewServicos = binding.recyclerViewServicos
        recyclerViewServicos.layoutManager = GridLayoutManager(this, 2)
        servicosAdapter = ServicosAdapter(this, listaServicos)
        recyclerViewServicos.setHasFixedSize(true)
        recyclerViewServicos.adapter = servicosAdapter
        getServicos()

        binding.btnAgendar.setOnClickListener(){
            val intent = Intent(this, Agendamento::class.java)
            intent.putExtra("nome", nome)
            startActivity(intent)
        }
    }

    private fun getServicos(){

        val servico1 = Servico(R.drawable.img1, "Corte de cabelo")
        listaServicos.add(servico1)

        val servico2 = Servico(R.drawable.img2, "Corte de barba")
        listaServicos.add(servico2)

        val servico3 = Servico(R.drawable.img3, "Lavagem de cabelo")
        listaServicos.add(servico3)

        val servico4 = Servico(R.drawable.img4, "Tratamento de cabelo")
        listaServicos.add(servico4)
    }
}