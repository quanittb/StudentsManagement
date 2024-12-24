package com.example.studentsmanagement.fragment

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsmanagement.adapter.ImageAdapter
import com.example.studentsmanagement.adapter.OnClickListener
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentNewsDetailBinding

class NewsDetailFragment:BaseFragment<FragmentNewsDetailBinding>() {
    companion object{
        fun instance():NewsDetailFragment{
            return newInstance(NewsDetailFragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNewsDetailBinding {
        return FragmentNewsDetailBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        var imgAdapter = ImageAdapter(requireContext() , object : OnClickListener{
            override fun onClickDetail() {

            }
        })
        var listImg: ArrayList<String> = arrayListOf()
        listImg.add("a")
        listImg.add("b")
        listImg.add("c")
        listImg.add("d")
        imgAdapter.setItems(listImg)
        binding.rcvImg.adapter = imgAdapter
        val space = 16 // Khoảng cách giữa các item (px)

        binding.rcvImg.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
            ) {
                val position = parent.getChildAdapterPosition(view)
                if (position == 0) {
                    outRect.left = space // Thêm padding cho item đầu tiên
                }
                outRect.right = space
            }
        })
    binding.icBack.setOnClickListener {
        handlerBackPressed()
    }
    }

    override fun handlerBackPressed() {
        super.handlerBackPressed()
        hideFragment(this@NewsDetailFragment)
    }
}