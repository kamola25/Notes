package com.kiro.notes.ui.fragment.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.kiro.notes.core.IItemClick
import com.kiro.notes.data.entity.NoteModel
import com.kiro.notes.R
import com.kiro.notes.databinding.FragmentNoteBinding

class NoteFragment : Fragment(), IItemClick {
    private lateinit var binding: FragmentNoteBinding
    private lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAddListener()

        adapter = NoteAdapter(this)

        binding.mainRecycler.adapter = adapter
        binding.sort.setOnClickListener {
            adapter.sort()
        }
    }

    private fun setAddListener() {
        binding.addNote.setOnClickListener{
            if (binding.editNote.text.isBlank()){
                binding.editNote.error= "Error"
            }else {
                val note =
                    NoteModel(binding.editNote.text.toString(), binding.editNote2.text.toString())
                adapter.addNote(note)
                binding.editNote.text.clear()
                binding.editNote2.text.clear()

            }

        }
    }

    override fun delete(pos: Int) {
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle(getString(R.string.warning))
        alert.setMessage(getString(R.string.message))
        alert.setPositiveButton("ok") { _, _ ->

        }
        alert.setNegativeButton(getText(R.string.cancel),null)
        alert.show()
        adapter.delete(pos)

    }

    override fun edit(pos: Int) {
        val editNote = adapter.getList()[pos]
        binding.editNote.setText(editNote.title)
        binding.editNote2.setText(editNote.desc)
        binding.addNote.text = getString(R.string.edit)
        binding.addNote.setOnClickListener {
            if (binding.editNote.text.isBlank()){
                binding.editNote.error= "Error"
            }else{
                val newNote = NoteModel(binding.editNote.text.toString(),binding.editNote2.text.toString())
                adapter.edit(pos,newNote)
            }

        }
    }

}