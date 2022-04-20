package com.example.mysandbox.SharedPreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.mysandbox.R

class LoginActivity : AppCompatActivity() {
    val PREFS_NAME = "TestSharedPrefrence"
    val KEY_EMAIL = "key.email"
    val KEY_PASSWORD = "key.password"
    lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun onLogin(view: View) {
        val email = findViewById<TextView>(R.id.input_email).text.toString()
        saveEmail(email)
        val password = findViewById<TextView>(R.id.input_password).text.toString()
        savePassword(password)
        message()
    }

    private fun saveEmail(email: String) {
        val editor = sharedPref.edit()
        editor.putString(KEY_EMAIL, email)
        editor.apply()
    }

    private fun savePassword(password: String) {
        val editor = sharedPref.edit()
        editor.putString(KEY_PASSWORD, password)
        editor.apply()
    }

    private fun message() {
        val email :String = findViewById<TextView>(R.id.input_email).text.toString()
        val password :String = findViewById<TextView>(R.id.input_password).text.toString()
        when {
            email == "" -> {
                val message = Toast.makeText(applicationContext, "Masukan Email", Toast.LENGTH_LONG)
                message.setGravity(Gravity.TOP, 0, 140)
                message.show()
            }
            password == "" -> {
                val message = Toast.makeText(applicationContext, "Masukan Password", Toast.LENGTH_LONG)
                message.setGravity(Gravity.TOP, 0, 140)
                message.show()
            }
            else -> {
                val message = Toast.makeText(applicationContext, "Berhasil Login", Toast.LENGTH_LONG)
                message.setGravity(Gravity.TOP, 0, 140)
                message.show()
                startActivity(Intent(this, AfterLoginActivity::class.java))
            }
        }
    }
}