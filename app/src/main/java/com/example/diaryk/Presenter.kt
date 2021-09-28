package com.example.diaryk

import com.example.diaryk.model.Note

class Presenter {
    private var note: Note? = null
    private var view: View? = null
    var num = "sadasd"

    fun Presenter(view: View?) {
        note = Note()
        this.view = view
    }

    fun onSaveClick(note: String?) {
        this.note?.addNote(note)
        view?.addNote2List(this.note?.getNote())
        view?.clearInput()
    }
}