package com.example.toolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.appcompat.widget.Toolbar

class PantallaDos : AppCompatActivity() {

    var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_dos)

        toolbar = findViewById(R.id.toolbarDos)
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        //Habilita el boton hacia atras, s epuede configurar parent root en manifest
        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_pantalla_dos,menu)
        return super.onCreateOptionsMenu(menu)
    }
}