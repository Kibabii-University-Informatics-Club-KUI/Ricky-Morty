package com.kanyideveloper.rickymorty.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kanyideveloper.rickymorty.databinding.CharacterRowBinding
import com.kanyideveloper.rickymorty.model.Result

class CharactersAdapter : ListAdapter<Result, CharactersAdapter.MyViewHolder>(MyDiffUtil) {

    object MyDiffUtil : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

    }

    inner class MyViewHolder(private val binding: CharacterRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Result) {
            binding.characterNameTextView.text = character.name
            Glide.with(binding.characterImageView).load(character.image)
                .into(binding.characterImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CharacterRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
    }
}