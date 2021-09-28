package com.example.diaryk.model

import java.text.SimpleDateFormat
import java.util.*

class Note {

    private var dateText: String? = null

    fun addNote(note: String?) {
        val date = Date()
        val dateFormat = SimpleDateFormat("EEE, d mm yyyy HH:mm:ss")
        dateText = "<strong>" + dateFormat.format(date) + "</strong>" + " " + note
    }

    fun getNote(): String? {
        return dateText
    }
}