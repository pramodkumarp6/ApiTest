package com.pramod.corotine

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import com.pramod.apitest.databinding.ActivityMainBinding
import com.pramod.corotine.api.ApiInterface
import com.pramod.corotine.api.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var mbinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)




        mbinding.button.setOnClickListener {




                GlobalScope.launch(Dispatchers.Main) {

                getData()


            }

        }
    }

    private suspend fun getData() {
        val userApi = RetrofitClient.getInstance().create(ApiInterface::class.java)
        val response = userApi.getUser()

        if (response.body() != null) {



            response.body()?.iterator()?.forEach {
                /*Log.d("Title","id${it.id})");
                Log.d("Userid","userid${it.userId})");
                Log.d("Title","title${it.title})");
                Log.d("Body","body${it.body})");*/
                val Id = "${it.id}"
                val UserId = "${it.userId}"
                val Title = "${it.title}"
                val Body = "${it.body}"

                Log.e("Id",Id);

                mbinding.name1.append(Body+"body"+"\n")

            }


            /* val gson = GsonBuilder().setPrettyPrinting().create();
             Log.e("Json", gson.toJson(response.body()));*/

            mbinding.name1.append(title)
        }
    }

    private suspend fun createRegister() {
        val email = mbinding.email.text.toString()
        val password = mbinding.password.text.toString()
        val name = mbinding.name.text.toString()
        val school = mbinding.school.text.toString()
        Log.e(password, "pramod")
        if (email.isEmpty()){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_LONG).show()
            return
               }
        if (password.isEmpty()){
            Toast.makeText(this, "Enter password", Toast.LENGTH_LONG).show()
            return
        }

        if (name.isEmpty()){
            Toast.makeText(this, "Enter name", Toast.LENGTH_LONG).show()
            return
        }

        if (school.isEmpty()){
            Toast.makeText(this, "Enter School", Toast.LENGTH_LONG).show()
            return
        }
        val userApi = RetrofitClient.getInstance().create(ApiInterface::class.java)
        val response = userApi.createUser(email, password, name, school)

        if (response.code()==201) {
            Toast.makeText(this, response.body()?.message.toString(), Toast.LENGTH_LONG).show()

        } else if (response.code()==422) {
            Toast.makeText(this, "User Alredy exist", Toast.LENGTH_LONG).show()

        }


    }
}


