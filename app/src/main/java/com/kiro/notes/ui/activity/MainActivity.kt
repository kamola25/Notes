package com.kiro.notes.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kiro.notes.core.IItemClick
import com.kiro.notes.ui.fragment.note.NoteAdapter
import com.kiro.notes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IItemClick {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun delete(pos: Int) {

    }

    override fun edit(pos: Int) {

    }


}