package com.example.android4a.presentation.main

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.android4a.R

class ItemsListAdapter(var context: Context, var arrayList:ArrayList<ItemList> ) : BaseAdapter() {



    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       val view:View = View.inflate(context, R.layout.item_list_view_layout, null)

        var imageView: ImageView = view.findViewById(R.id.icon_image_view)
        var titleText:TextView = view.findViewById(R.id.title_text_view)
        var detailText:TextView = view.findViewById(R.id.details_text_view)

        var itemList:ItemList = arrayList.get(position)
        imageView.setImageResource(itemList.icons!!)
        titleText.text = itemList.title
        detailText.text = itemList.details

        return view
    }

}