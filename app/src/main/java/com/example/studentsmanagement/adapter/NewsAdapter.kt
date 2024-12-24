package com.example.studentsmanagement.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.example.studentsmanagement.R
import com.example.studentsmanagement.base.BaseAdapter
import com.example.studentsmanagement.databinding.ItemNewsBinding

class NewsAdapter(val context: Context, private val listener: OnClickListener):BaseAdapter<Boolean,ItemNewsBinding>() {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ItemNewsBinding {
        return  ItemNewsBinding.inflate(inflater,parent,false)
    }
    var isLove = false
    override fun bind(binding: ItemNewsBinding, item: Boolean, position: Int) {
        binding.root.setOnClickListener{
            listener.onClickDetail()
        }
        binding.img.setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.img1))
        if(item){
            isLove = true
            binding.ivLove.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_love_red))
            binding.ivMark.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_mark_select))
        }
        else
        {
            isLove = false
            binding.ivLove.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_love))
            binding.ivMark.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_mark))
        }
        binding.ivLove.setOnClickListener {
            isLove = !isLove
            if(isLove){
                binding.ivLove.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_love_red))
                binding.ivMark.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_mark_select))
            }else{
                binding.ivLove.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_love))
                binding.ivMark.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_mark))
            }
        }
        binding.ivMark.setOnClickListener {
            isLove = !isLove
            if(isLove){
                binding.ivLove.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_love_red))
                binding.ivMark.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_mark_select))
            }else{
                binding.ivLove.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_love))
                binding.ivMark.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_mark))
            }
        }
    }
}
