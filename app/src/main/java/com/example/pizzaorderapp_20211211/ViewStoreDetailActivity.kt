package com.example.pizzaorderapp_20211211

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.pizzaorderapp_20211211.datas.StoreData
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_view_store_detail.*

class ViewStoreDetailActivity : AppCompatActivity() {
    lateinit var mStoreData : StoreData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)

        setupEvents()
        setValues()
    }

    fun setupEvents() {
        btnCall.setOnClickListener {
            val pl = object : PermissionListener {
                override fun onPermissionGranted() {

                    val callUri = Uri.parse("tel:${mStoreData.phone}")
                    val callIntent = Intent(Intent.ACTION_CALL, callUri)
                    startActivity(callIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(this@ViewStoreDetailActivity, "통화 권한 거부", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission
                .create()
                .setPermissionListener(pl)
                .setPermissions(android.Manifest.permission.CALL_PHONE)
                .check()
        }
    }

    fun setValues() {
        mStoreData = intent.getSerializableExtra("store") as StoreData

        Glide.with(this).load(mStoreData.logoURL).centerCrop().into(imgLogo)
        txtStoreName.text = mStoreData.name
        txtPhoneNum.text = mStoreData.phone
    }
}