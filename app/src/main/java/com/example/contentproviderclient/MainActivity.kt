package com.example.contentproviderclient

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var rvClientList: RecyclerView
    lateinit var fabRefresh: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvClientList = findViewById(R.id.rvClientList)
        fabRefresh = findViewById(R.id.fabRefresh)
        getContentProvider()

        fabRefresh.setOnClickListener {
            getContentProvider()
        }
    }

    private fun getContentProvider() {
        try {
            val url = "content://com.example.notescontentprovider.provider/notes"
            val uri = Uri.parse(url)
            val cursor: Cursor? = contentResolver
                .query(uri, null, null, null, "title")

            rvClientList.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = NoteAdapter(cursor as Cursor)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}