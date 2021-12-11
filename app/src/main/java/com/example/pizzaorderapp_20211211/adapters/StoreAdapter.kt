package com.example.pizzaorderapp_20211211.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pizzaorderapp_20211211.R
import com.example.pizzaorderapp_20211211.datas.StoreData

class StoreAdapter(
    val mContext: Context,
    val resId: Int,
    var mList: ArrayList<StoreData>
): ArrayAdapter<StoreData>(mContext, resId, mList) {

    val mInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if(tempRow == null) {
            tempRow = mInflater.inflate(R.layout.store_list_item, null)
        }

        val row = tempRow!!

        val data = mList[ position ]

        val imgLogo         = row.findViewById<ImageView>(R.id.imgLogo)
        val txtStoreName    = row.findViewById<TextView>(R.id.txtStoreName)

        Glide.with(mContext).load(data.logoURL).centerCrop().into(imgLogo)
        txtStoreName.text = data.name

        return row
    }
}