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
import com.example.alancasas.recyclerview_cardview.Model.Movie
import com.example.alancasas.recyclerview_cardview.R

class MainActivity : AppCompatActivity() {

    //Creamos las variables que vamos a necesitar sin inicializarlas en un principio
    lateinit var movies: ArrayList<Movie>
    lateinit var recyclerView : RecyclerView
    lateinit var layoutManager : RecyclerView.LayoutManager
    lateinit var adapter: MyAdapter

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movies = getAllMoviess()
        recyclerView = findViewById(R.id.recycler_view)
        layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(movies, R.layout.recycler_view_item, object : CustomOnItemClickListener{
            override fun onCustomItemClickListener(movie: Movie, position: Int) {

                //                deleteElement(position)
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
//            addNewElement(0)
            return true
        }else{
            return super.onOptionsItemSelected(item)
        }
    }

    fun getAllMoviess() : ArrayList<Movie>{
        return  arrayListOf(
                Movie("Blade Runner 2049", R.drawable.blade_runner_2049),
                Movie("Thor: Ragnarok", R.drawable.thor_ragnarok),
                Movie("Enganchados a la muerte", R.drawable.enganchados_a_la_muerte),
                Movie("American Assassin", R.drawable.american_assassin),
                Movie("Con los brazos abiertos", R.drawable.con_los_brazos_abiertos),
                Movie("Liga de la Justicia", R.drawable.justice_league)
        )

    }
//
//    fun addNewElement ( position: Int ){
//        movies.add(position, "New name ${++counter} ")
//        adapter.notifyItemInserted(position)
//        layoutManager.scrollToPosition(position)
//    }
//
//    fun deleteElement (position : Int) {
//        movies.removeAt(position)
//        adapter.notifyItemRemoved(position)
//    }

}
