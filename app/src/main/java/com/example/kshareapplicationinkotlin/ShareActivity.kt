package com.example.kshareapplicationinkotlin

import android.app.Notification
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.TextView

class ShareActivity : AppCompatActivity() {
    var tv_share : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
       initView()
       intentContent()
    }
    fun initView(){
        tv_share = findViewById(R.id.tv_share)
    }
    fun intentContent(){
        var intent = intent
        var type = intent.type
        var action = intent.action

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)){
                handleSendText(intent)
            }else if (type.startsWith("image/")){
                handleSendImage(intent)
            }
        }else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
            if (type.startsWith("image/")) handleSendMultipleImage(intent)
        }
    }
    fun handleSendText(intent: Intent){
        val textReq = intent.getStringExtra(Intent.EXTRA_TEXT)
        if (textReq != null) {
            tv_share!!.text = textReq
        }
    }
    fun handleSendImage(intent: Intent){
        val uri  = intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM)
        if (uri != null) {

        }
    }
    fun handleSendMultipleImage(intent: Intent){
        val uris = intent.getParcelableArrayListExtra<Uri>(Intent.EXTRA_TEXT)
        if (uris != null) {

        }
    }
}