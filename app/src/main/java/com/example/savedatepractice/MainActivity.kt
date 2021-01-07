package com.example.savedatepractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.BufferedReader
import java.io.File

class MainActivity : AppCompatActivity() {

    val fileName = "testfile.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveButton = findViewById<Button>(R.id.saveBtn)

        saveButton.setOnClickListener() {

            val textview = findViewById<TextView>(R.id.savedText)

            val contents = findViewById<EditText>(R.id.textHere).text.toString()

            File(applicationContext.filesDir, fileName).writer().use {
                it.write(contents)
            }

            val readFile = File(applicationContext.filesDir, fileName)

            if (readFile.exists()) {
                val finalContents = readFile.bufferedReader().use(BufferedReader::readText)
                textview.text = finalContents
            }




        }

    }
}
