package com.example.piranti

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MoveActivityWithData : AppCompatActivity() {
    private lateinit var tvDataReceived : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_with_data)

        tvDataReceived = findViewById(R.id.tv_data_received)
        DataReceived()
    }

    @SuppressLint("SetTextI18n")
    private fun DataReceived(){
        val bundle = intent.extras
        val nama = bundle?.getString("Nama")
        val alamat = bundle?.getString("Alamat")

        tvDataReceived.text = "$nama $alamat"
    }
}

