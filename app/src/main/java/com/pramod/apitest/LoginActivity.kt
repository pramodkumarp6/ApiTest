package com.pramod.apitest

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.pramod.apitest.api.RetrofitClient
import com.pramod.apitest.databinding.ActivityLoginBinding
import com.pramod.apitest.navi.DashActivity
import com.pramod.apitest.utils.hide
import com.pramod.apitest.utils.show
import com.pramod.apitest.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity:AppCompatActivity() {
    private lateinit var mbinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        title ="LoginActivity"
        mbinding.signup.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java  )
            startActivity(intent)
        }

        mbinding.button.setOnClickListener{
            GlobalScope.launch (Dispatchers.Main){
                login()

            }
        }


    }

    private suspend fun login() {
        val email = mbinding.email.text.toString()
        val password = mbinding.password.text.toString()
        if (TextUtils.isEmpty("email")) {
            toast("Enter Email")
            return
        }
        if (password.isEmpty()) {

            toast("Enter password")
            return
        }

        mbinding.p.show()

        val userApi = RetrofitClient.getInstance().login(email, password)
        if (userApi.body() != null) {
            mbinding.p.hide()
            val intent = Intent(this,DashActivity::class.java  )
            startActivity(intent)
            toast(userApi.body()?.message.toString())
        } else if (userApi.code() == 422) {

            toast(userApi.message().toString())
            mbinding.p.hide()

        }


    }
}