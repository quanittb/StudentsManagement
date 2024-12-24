package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentLichthiBinding

class LichThiFragment:BaseFragment<FragmentLichthiBinding>() {
    companion object{
        fun instance(): LichThiFragment{
            return newInstance(LichThiFragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLichthiBinding {
        return FragmentLichthiBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        binding.icBack.setOnClickListener {
            handlerBackPressed()
        }

    }

    override fun handlerBackPressed() {
        super.handlerBackPressed()
        hideFragment(this)
    }
}