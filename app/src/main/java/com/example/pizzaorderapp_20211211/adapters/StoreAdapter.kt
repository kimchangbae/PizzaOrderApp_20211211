package com.example.pizzaorderapp_20211211.adapters

import android.content.Context
import android.widget.Adapter
import android.widget.ArrayAdapter
import com.example.pizzaorderapp_20211211.datas.StoreData

class StoreAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<StoreData>
): ArrayAdapter<StoreData>(mContext, resId, mList) {

}