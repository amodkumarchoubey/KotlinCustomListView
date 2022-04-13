 package com.amod.kotlincustomlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import mchehab.com.customlistviewimage.ListViewAdapter
import mchehab.com.customlistviewimage.Person
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.channels.DatagramChannel.open

 class MainActivity : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         val listView = findViewById<ListView>(R.id.listView)
         listView.adapter = ListViewAdapter(this, readListFromFile())
     }

     private fun readListFromFile(): List<Person> {
         val jsonString = assets.open("persons.txt")
             .bufferedReader()
             .readText()
         val gson = Gson()

         return gson.fromJson(jsonString, object : TypeToken<List<Person>>() {}.type)

     }
 }