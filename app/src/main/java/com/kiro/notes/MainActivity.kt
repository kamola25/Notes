package com.kiro.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kiro.notes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IItemClick {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NoteAdapter(this)

        binding.mainRecycler.adapter = adapter

        binding.addNote.setOnClickListener{
           if (binding.editNote.text.isBlank()){
               binding.editNote.error= "Error"
           }else{
               val note = NoteModel(binding.editNote.text.toString(),binding.editNote2.text.toString())
               adapter.addNote(note)
               binding.editNote.text.clear()
               binding.editNote2.text.clear()

           }
        }

    }

    override fun delete(pos: Int) {
        adapter.delete(pos)
    }

    override fun edit(pos: Int) {
        val editNote = adapter.getList()[pos]
        binding.editNote.setText(editNote.title)
        binding.editNote2.setText(editNote.desc)
        binding.addNote.setOnClickListener {
            val newNote = NoteModel(binding.editNote.text.toString(),binding.editNote2.text.toString(),)
            adapter.edit(pos,newNote)
        }

    }
}