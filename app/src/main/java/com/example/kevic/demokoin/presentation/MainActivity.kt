package com.example.kevic.demokoin.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.kevic.demokoin.R
import com.example.kevic.demokoin.utils.injectActivity

class MainActivity : AppCompatActivity(), MainView {

    private val mainPresenter: MainPresenter by injectActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter.getUsername()
    }

    override fun showUsername(username: String) {
        Log.e("LOG", username)
    }

}
