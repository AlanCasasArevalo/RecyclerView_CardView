package com.example.alancasas.recyclerview_cardview.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.alancasas.recyclerview_cardview.Adapters.MyAdapter
import com.example.alancasas.recyclerview_cardview.Interfaces.CustomOnItemClickListener
import com.example.alancasas.recyclerview_cardview.R

class MainActivity : AppCompatActivity() {

    //Creamos las variables que vamos a necesitar sin inicializarlas en un principio
    lateinit var names : ArrayList<String>
    lateinit var recyclerView : RecyclerView
    lateinit var layoutManager : RecyclerView.LayoutManager
    lateinit var adapter: MyAdapter

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        names = getAllNames()
        recyclerView = findViewById(R.id.recycler_view)
        layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(names, R.layout.recycler_view_item, object : CustomOnItemClickListener{
            override fun onCustomItemClickListener(name: String, position: Int) {
                Toast.makeText(applicationContext,"Estamos borrando a  ${name}", Toast.LENGTH_LONG).show()
                deleteElement(position)
            }
        })

        recyclerView.setHasFixedSize(true)

        recyclerView.itemAnimator = DefaultItemAnimator()

        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.add_name){
            addNewElement(0)
            return true
        }else{
            return super.onOptionsItemSelected(item)
        }
    }

    fun getAllNames () : ArrayList<String>{
        return  arrayListOf(
                "Alan",
                "Bibi",
                "Mario",
                "Elsa",
                "Pilar",
                "Pedro"
        )

    }

    fun addNewElement ( position: Int ){
        names.add(position, "New name ${++counter} ")
        adapter.notifyItemInserted(position)
        layoutManager.scrollToPosition(position)
    }

    fun deleteElement (position : Int) {
        names.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

}
