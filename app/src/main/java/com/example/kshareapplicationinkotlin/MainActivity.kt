package com.example.kshareapplicationinkotlin

import android.app.Activity
import android.app.Notification
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         initView()
    }
    fun initView(){
        val show_browser = findViewById<Button>(R.id.show_browser)
        show_browser.setOnClickListener {
            shareTextAndImage("Cold Winter", Uri.parse("android.resource://com.example.kshareapplicationinkotlin/drawable/photo.jpg"))
        }
    }
    fun shareTextAndImage(text : String,uri: Uri){
        val intent = Intent()
        intent.setAction(Intent.ACTION_SEND)
        intent.setType("image/*")
        intent.putExtra(Intent.EXTRA_TEXT,text)
        intent.putExtra(Intent.EXTRA_STREAM,uri)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(Intent.createChooser(intent,"Share"))
    }
    fun shareLinkWith(uri : String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,uri)
        startActivity(Intent.createChooser(intent,"Share"))
    }
    fun openBrowser(uri : String){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(uri))
        startActivity(intent)
    }
}