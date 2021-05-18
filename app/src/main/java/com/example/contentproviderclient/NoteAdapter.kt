package com.example.contentproviderclient

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val mCursor: Cursor): RecyclerView.Adapter<NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mCursor.count
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        holder.tvNoteTitle.text = mCursor.getString(mCursor.getColumnIndex("title"))
        holder.tvNoteDescription.text = mCursor.getString(mCursor.getColumnIndex("description"))
    }
}

class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvNoteTitle = itemView.findViewById(R.id.tvNoteTitle) as TextView
    val tvNoteDescription = itemView.findViewById(R.id.tvNoteDescription) as TextView
}