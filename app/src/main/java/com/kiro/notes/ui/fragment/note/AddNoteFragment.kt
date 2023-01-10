package com.kiro.notes.ui.fragment.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import com.kiro.notes.R
import com.kiro.notes.data.entity.NoteModel
import com.kiro.notes.databinding.FragmentAddNoteBinding
import com.kiro.notes.databinding.FragmentNoteBinding

class AddNoteFragment : Fragment() {


    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.add.setOnClickListener {
            val result = "result"
            // Здесь мы можем использовать Kotlin экстеншен функцию из fragment-ktx
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))

        }

       // binding.add.setOnClickListener {
         //  if (binding.editTitle.text.isBlank()){
           //     binding.editTitle.error= "Error"
            }//else{
               // val newNote = NoteModel(binding.editTitle.text.toString(),binding.editDesc.text.toString())

            }






