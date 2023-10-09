package com.example.mylog_inapplication

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

   lateinit var exitApp : ImageButton
    lateinit var emailText : EditText
    lateinit var passwordText : EditText
    lateinit var entrar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exitApp = this.findViewById(R.id.exitApp)

       exitApp.setOnClickListener {
            finishAffinity()
        }

        emailText = this.findViewById(R.id.emailText)
        passwordText = this.findViewById(R.id.passwordText)
        entrar = this.findViewById(R.id.entrar)

        emailText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(emailText.length() >=1 && passwordText.length() >= 1){
                    entrar.isEnabled = true
                } else{
                    entrar.isEnabled = false
                }
            }


            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(emailText.length() >= 1 && passwordText.length() >= 1){
                    entrar.isEnabled = true
                }else{
                    entrar.isEnabled = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                if(emailText.length() >= 1 && passwordText.length() >= 1){
                    entrar.isEnabled = true
                }else{
                    entrar.isEnabled = false
                }
            }


        }
        )

        entrar.setOnClickListener {

            if (emailText.text.toString().length==0){
                Toast.makeText(this, "el email no puede estar vacío",Toast.LENGTH_LONG).show()
            }

            else if (passwordText.text.toString().length==0){
                Toast.makeText(this, "la contraseña no puede estar vacía",Toast.LENGTH_LONG).show()
            }
            else if (passwordText.text.toString().length<6||passwordText.text.toString().length>8){
                Toast.makeText(this, "la contraseña debe contener entre 6 y 8 caracteres",Toast.LENGTH_LONG).show()
            }

        }




    }
}