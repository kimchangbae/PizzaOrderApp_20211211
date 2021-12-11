package com.example.pizzaorderapp_20211211

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)

        setupEvents()
        setValuse()
    }

    private fun setupEvents() {
        btnOk.setOnClickListener {
            val inputNickname = edtNickname.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("nickname", inputNickname)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun setValuse() {

    }
}