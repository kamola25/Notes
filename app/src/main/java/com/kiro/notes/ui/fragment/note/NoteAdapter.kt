package com.kiro.notes.ui.fragment.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kiro.notes.core.IItemClick
import com.kiro.notes.data.entity.NoteModel
import com.kiro.notes.databinding.ItemNoteBinding

class NoteAdapter(private val listener: IItemClick): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private var list:MutableList<NoteModel> = ArrayList()

    fun addNote(note: NoteModel){
        list.add(note)
        notifyItemInserted(list.size )

    }fun sort(){
        list.sortBy { it.title }
        notifyDataSetChanged()
    }
    fun delete(pos:Int){
        list.removeAt(pos)
        notifyItemRemoved(pos)
    }
    fun edit(pos:Int,note: NoteModel) {
        list.set(pos,note)
        notifyItemChanged(pos)
    }
   inner class ViewHolder(private val binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(note: NoteModel){
            binding.itemText.text = note.title
            binding.itemText2.text = note.desc
            binding.itemDelete.setOnClickListener{
                listener.delete(adapterPosition)

            }
            binding.itemEdit.setOnClickListener{
                listener.edit(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }
    fun getList(): MutableList<NoteModel>{
        return list

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size

}}
