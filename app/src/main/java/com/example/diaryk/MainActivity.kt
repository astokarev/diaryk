package com.example.diaryk

import android.graphics.text.LineBreaker
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener, com.example.diaryk.View {
    private val presenter: Presenter = Presenter()
    val editText: EditText? = findViewById(R.id.editText)
    val saveButton: Button? = findViewById(R.id.saveButton)
    val noteList: LinearLayout? = findViewById(R.id.noteCntnr)

    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText?.setBreakStrategy(LineBreaker.BREAK_STRATEGY_SIMPLE)
        saveButton?.setEnabled(false)
        saveButton?.setOnClickListener(this)
        editText?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.saveButton -> {
                val noteText = editText!!.text.toString()
                presenter.onSaveClick(noteText)
                saveButton!!.isEnabled = true
            }
            R.id.editText -> saveButton!!.isEnabled = true
        }
    }

    override fun addNote2List(noteText: String?) {
        var id = 0
        val note = TextView(this)
        note.id = id++
        note.gravity = 1
        noteList!!.addView(note)
        note.text = Html.fromHtml(noteText)
    }

    override fun clearInput() {
        editText!!.text.clear()
    }
}