package com.example.mylog_inapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

   lateinit var exitApp : ImageButton
    lateinit var emailText : EditText
    lateinit var passwordText : EditText
    lateinit var login : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exitApp = this.findViewById(R.id.exitApp)

       exitApp.setOnClickListener {
            finishAffinity()
        }

        emailText = this.findViewById(R.id.emailText)
        passwordText = this.findViewById(R.id.passwordText)
        login = this.findViewById(R.id.login)

        emailText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }


            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if(emailText.length() >= 1){
                    login.isEnabled = true
                }else{
                    login.isEnabled = false
                }
            }


        }
        )

        login.setOnClickListener {

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



        ////Validar contraseña

        val checkPass : Boolean =false

        //entre 6 y 8
        val ncharacter = Regex("^{6,8}$")

        //una mayuscula
        val upperC = Regex(".*[A-Z].*")

        //una minuscula
        val lowerC = Regex(".*[a-z].*")

        //un numero
        val number = Regex(".*\\d+.*")

        passwordText.setOnEditorActionListener(OnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE || keyEvent.action == KeyEvent.ACTION_DOWN || keyEvent.action == KeyEvent.KEYCODE_ENTER) {

                if(!ncharacter.containsMatchIn(passwordText.toString())) {
                    passwordText.setError("la contraseña debe contener entre 6 y 8 dígitos")
                }else if(!upperC.containsMatchIn(passwordText.toString())){
                    passwordText.setError("la contraseña debe contener como minimo una mayuscula")
                }else if(!lowerC.containsMatchIn(passwordText.toString())) {
                    passwordText.setError("la contraseña debe contener como minimo una minuscula")
                }else if(!number.containsMatchIn(passwordText.toString())) {
                    passwordText.setError("la contraseña debe contener como minimo un numero")
                }else{
                    passwordText.setError(null)
                    checkPass == true
                    }

                    false

                }

                return@OnEditorActionListener true

            false
        })


//Validar email


        val checkEmail : Boolean =false


        val reEmail = Regex("^[A-Za-z0-9+_.-]+@(.+)$")

        emailText.setOnEditorActionListener(OnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE || keyEvent.action == KeyEvent.ACTION_DOWN || keyEvent.action == KeyEvent.KEYCODE_ENTER) {

                if(!reEmail.containsMatchIn(emailText.toString())){
                  emailText.setError("no es un email válido")
                }else{
                    emailText.setError(null)
                    checkEmail == true
                }

                false

            }

            return@OnEditorActionListener true

            false
        })


    }
}