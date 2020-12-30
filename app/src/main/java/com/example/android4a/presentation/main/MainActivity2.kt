package com.example.android4a.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.android4a.R
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity(), AdapterView.OnItemClickListener{
   private var listView:ListView ? = null
   private var itemsListAdapters:ItemsListAdapter ? =null
    private var arrayList:ArrayList<ItemList> ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        listView = findViewById<ListView>(R.id.custom_list_view)
        var intent = intent
        val nom = intent.getStringExtra("nom")
        textView7.text = "Bonjour : "+ nom
        arrayList = ArrayList()
        arrayList = setDataArrayList()
        itemsListAdapters = ItemsListAdapter(applicationContext, arrayList!!)
        listView?.adapter = itemsListAdapters
    }

    private fun setDataArrayList() : ArrayList<ItemList>{
        var arrayList:ArrayList<ItemList> = ArrayList()
        arrayList.add(ItemList(R.drawable.ic_launcher,"Programmation Mobile", "4A créer une application de son choix : 30 Decembre 2020"))
        arrayList.add(ItemList(R.drawable.csharp,"Unity", "Terminer l'application RA : 14 Decembre 2020"))
        arrayList.add(ItemList(R.drawable.cplus,"Bus de Terrain ", "C++ remettre le rapport : 12 Decembre 2020 "))
        arrayList.add(ItemList(R.drawable.cplus,"IHM", "Utiliser Qt pour créer un interface permettant de modifier fonction & dev limité : 28 Decembre 2020"))
        arrayList.add(ItemList(R.drawable.ce,"Communication sans fils", "Reunion projet et rapport a réaliser : 7 Janvier 2021"))
        return arrayList!!
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        var items:ItemList = arrayList?.get(position)!!
        Toast.makeText(this, "A faire !!! ", Toast.LENGTH_SHORT).show()
    }
}