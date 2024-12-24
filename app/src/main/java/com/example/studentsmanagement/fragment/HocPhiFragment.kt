package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentHocphiBinding
import com.example.studentsmanagement.databinding.FragmentNghiphepBinding

class HocPhiFragment:BaseFragment<FragmentHocphiBinding>() {
    companion object{
        fun instance():HocPhiFragment{
            return newInstance(HocPhiFragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHocphiBinding {
        return FragmentHocphiBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        binding.icBack.setOnClickListener {
            handlerBackPressed()
        }
    }

    override fun handlerBackPressed() {
        super.handlerBackPressed()
        hideFragment(this@HocPhiFragment)
    }
}