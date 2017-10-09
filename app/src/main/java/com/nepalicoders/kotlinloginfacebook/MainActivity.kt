package com.nepalicoders.kotlinloginfacebook

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callbackManager = CallbackManager.Factory.create()
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "email"))
        login_button.registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onCancel() {
                        Log.d("MainActivity", "Facebook onCancel")
                    }

                    override fun onError(error: FacebookException?) {
                        Log.d("MainActivity", "Facebook onError")
                    }

                    override fun onSuccess(loginResult: LoginResult?) {
                        Log.d("MainActivity", "Facebook token: " + loginResult?.accessToken?.token)
                    }

                })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager?.onActivityResult(requestCode, resultCode, data)
    }
}
