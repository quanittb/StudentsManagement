package com.example.studentsmanagement.fragment

import android.graphics.Color
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsmanagement.R
import com.example.studentsmanagement.adapter.NewsAdapter
import com.example.studentsmanagement.adapter.OnClickListener
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentNewsBinding

class NewFragment : BaseFragment<FragmentNewsBinding>() {
    companion object {
        fun instance(): NewFragment {
            return newInstance(NewFragment::class.java)
        }
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentNewsBinding {
        return FragmentNewsBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        binding.icBack.setOnClickListener {
            handlerBackPressed()
        }
        var imgAdapter = NewsAdapter(requireContext(), object : OnClickListener{
            override fun onClickDetail() {
                addFragment(NewsDetailFragment.instance())
            }
        })
        var listImg: ArrayList<Boolean> = arrayListOf()
        listImg.add(false)
        listImg.add(false)
        listImg.add(false)
        listImg.add(false)

        imgAdapter.listItem = listImg
        binding.rcvNews.adapter = imgAdapter

        var listImgMark: ArrayList<Boolean> = arrayListOf()
        listImgMark.add(true)
        listImgMark.add(true)

        binding.tvAll.setOnClickListener {
            binding.tvAll.setBackgroundResource(R.drawable.bg_corner_10_primary)
            binding.tvAll.setTextColor(Color.WHITE)
            binding.tvMark.setTextColor(Color.parseColor("#80000000"))
            binding.tvMark.setBackgroundResource(R.color.white)
            imgAdapter.listItem = listImg
            binding.rcvNews.adapter = imgAdapter
        }
        binding.tvMark.setOnClickListener {
            binding.tvMark.setBackgroundResource(R.drawable.bg_corner_10_primary)
            binding.tvMark.setTextColor(Color.WHITE)
            binding.tvAll.setTextColor(Color.parseColor("#80000000"))
            binding.tvAll.setBackgroundResource(R.color.white)
            imgAdapter.listItem = listImgMark
            binding.rcvNews.adapter = imgAdapter
        }

        val space = 24
        binding.rcvNews.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
            ) {
                outRect.top = space
            }
        })
    }

    override fun handlerBackPressed() {
        super.handlerBackPressed()
        hideFragment(this@NewFragment)
    }
}