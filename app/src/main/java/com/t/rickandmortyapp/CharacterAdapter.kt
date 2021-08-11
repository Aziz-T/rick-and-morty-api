package com.t.rickandmortyapp


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characters by lazy { mutableListOf<CharacterModel>() }

    fun setCharacters(characters: List<CharacterModel>) {
        if (characters.isNotEmpty()) {
            this.characters.clear()
        }

        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.character_item, parent, false)

        return CharacterViewHolder(itemView)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val textView : TextView = itemView.findViewById(R.id.textView)

        fun bind(character: CharacterModel) {
            with(itemView) {
                Glide.with(this)
                    .load(character.image)
                    .into(imageView)

                textView.text = character.name

                itemView.setOnClickListener{



                    val intent = Intent(itemView.context, InfoActivity::class.java).apply {
                        putExtra("character", character)
                    }
                    itemView.context.startActivity(intent)


                }
            }
        }
    }
}