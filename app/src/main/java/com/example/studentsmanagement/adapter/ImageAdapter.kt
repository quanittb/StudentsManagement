package com.example.studentsmanagement.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import com.example.studentsmanagement.R
import com.example.studentsmanagement.base.BaseAdapter
import com.example.studentsmanagement.databinding.ItemImageBinding

class ImageAdapter(val context: Context, private val listener: OnClickListener ):BaseAdapter<String,ItemImageBinding>() {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ItemImageBinding {
        return  ItemImageBinding.inflate(inflater,parent,false)
    }

    override fun bind(binding: ItemImageBinding, item: String, position: Int) {
        binding.img.setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.img1))
        binding.root.setOnClickListener{
            listener.onClickDetail()
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val params = holder.itemView.layoutParams
        params.width = (Resources.getSystem().displayMetrics.widthPixels / 1.5).toInt() // Hiển thị 1.5 item
        holder.itemView.layoutParams = params
    }
}
interface OnClickListener{
    fun onClickDetail()
}