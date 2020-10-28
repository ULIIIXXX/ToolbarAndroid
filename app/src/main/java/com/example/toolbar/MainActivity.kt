package com.example.toolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SearchView
import androidx.appcompat.widget.ShareActionProvider
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat


class MainActivity : AppCompatActivity() {

    var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbarDos)
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        val btnIr = findViewById<Button>(R.id.btn_ir)
        btnIr.setOnClickListener{
            val intent= Intent(this,PantallaDos::class.java)
            startActivity(intent)
        }





    }

    //Inflate es importnate para asociar XML como elementos
    //Mapea elementos mientras crea nu4estor menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)

        //Busqueda
        var itemBusqueda = menu?.findItem(R.id.busqueda)
        //Permite hacer la interaccion entre las funcionalidades de search view
        var vistaBusqueda =  itemBusqueda?.actionView as SearchView

        vistaBusqueda.queryHint = "Escribe palabra de busqueda"
        vistaBusqueda.setOnQueryTextFocusChangeListener { view, b ->
            Log.d("ListenerFocus",b.toString())
        }

        //Como filtrar los resultado antes de dar enter
        vistaBusqueda.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(p0: String?): Boolean {
                Log.d("OnqueryTextChanged", p0)
                return true
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                Log.d("OnQueryTextsubmit", p0)
                return true
            }
        })


        //Item compartir
        val share = menu?.findItem(R.id.share)
        val shareActioProvide = MenuItemCompat.getActionProvider(share) as ShareActionProvider
        compartirInten(shareActioProvide)

        return super.onCreateOptionsMenu(menu)


    }

    //Mapeamos de acuerdo al elemento que fue seleccinado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //podemos utiliza rla sentencia when
        when(item?.itemId){
            R.id.vFav -> {
                Toast.makeText(this,"Favorito agregado",Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }

    }

    private fun compartirInten(shareActionProvider: ShareActionProvider){
        if(shareActionProvider !=  null){
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Este es un mensaje compartido")
            shareActionProvider.setShareIntent(intent)
        }
    }
}