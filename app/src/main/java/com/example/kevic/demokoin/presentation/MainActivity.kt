package com.example.kevic.demokoin.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.kevic.demokoin.R
import com.example.kevic.demokoin.data.entities.Post
import com.example.kevic.demokoin.utils.injectActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val mainPresenter: MainPresenter by injectActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter.getUsername()
        mainPresenter.getPosts()
    }

    override fun showUsername(username: String) {
        Log.e("LOG", username)
    }

    override fun showPosts(posts: List<Post>) {
        Log.e("POSTS", posts.toString())
        text.text = posts.toString()
    }

}
