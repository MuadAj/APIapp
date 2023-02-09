package com.example.apiapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apiapp.databinding.FragmentPostItemBinding
import com.example.apiapp.model.Post


class PostAdapter : ListAdapter<Post, RecyclerView.ViewHolder>(DIFF_CALLBACK){
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Post>() {

            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return  oldItem.name == newItem.name || oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val  binding: FragmentPostItemBinding =
            FragmentPostItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }


    inner class ViewHolder(val itemBinding: FragmentPostItemBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Post){
            itemBinding.apply {
                tvTitle.text = item.id
                tvContent.text = item.name
            }
        }
    }
}