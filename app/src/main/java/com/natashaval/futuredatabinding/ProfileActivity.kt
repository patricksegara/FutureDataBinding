package com.natashaval.futuredatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val firstNameText = findViewById<TextView>(R.id.tv_first_name)
        firstNameText.text = intent.getStringExtra(FIRST_NAME_KEY)

        val lastNameText = findViewById<TextView>(R.id.tv_last_name)
        lastNameText.text = intent.getStringExtra(LAST_NAME_KEY)
    }

    companion object {
        const val FIRST_NAME_KEY = "first_name"
        const val LAST_NAME_KEY = "last_name"
    }
}