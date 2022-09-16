package com.pramod.apitest

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.pramod.apitest.databinding.ActivityMainBinding
import com.pramod.apitest.api.RetrofitClient
import com.pramod.apitest.utils.hide
import com.pramod.apitest.utils.show
import com.pramod.apitest.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var mbinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = setContentView(this, R.layout.activity_main)
        title ="RegisterActivity"
        mbinding.button.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                createRegister()
            }
        }
    }

    private suspend fun getData() {
        val userApi = RetrofitClient.getInstance().getUser()
        if (userApi.body() != null) {
            userApi.body()?.iterator()?.forEach {
                /*Log.d("Title","id${it.id})");
                Log.d("Userid","userid${it.userId})");
                Log.d("Title","title${it.title})");
                Log.d("Body","body${it.body})");*/
                val Id = "${it.id}"
                val UserId = "${it.userId}"
                val Title = "${it.title}"
                val Body = "${it.body}"

                Log.e("Id", Id);

            //    mbinding.name1.append(Body + "body" + "\n")

            }


            /* val gson = GsonBuilder().setPrettyPrinting().create();
             Log.e("Json", gson.toJson(response.body()));*/

           // mbinding.name1.append(title)
        }
    }


    private suspend fun createRegister() {
        val email = mbinding.email.text.toString()
        val password = mbinding.password.text.toString()
        val name = mbinding.name.text.toString()
        val school = mbinding.school.text.toString()

        if (TextUtils.isEmpty("email")) {
            toast("Enter Email")
            return
        }
        if (password.isEmpty()) {

            toast("Enter password")
            return
        }

        if (name.isEmpty()) {

            toast("Enter name")
            return
        }

        if (school.isEmpty()) {

            toast("Enter School")
            return
        }
         mbinding.p.show()
        val userApi = RetrofitClient.getInstance().createUser(email, password, name, school)

            if (userApi.body() != null) {
                mbinding.p.hide()
                toast(userApi.body()?.message.toString())
            } else if (userApi.code() == 422) {

                toast(userApi.message().toString())
                mbinding.p.hide()

            }


        }
    }


