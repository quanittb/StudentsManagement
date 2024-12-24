package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentHelpBinding

class HelpFragment:BaseFragment<FragmentHelpBinding>() {
    companion object{
        fun instance():HelpFragment{
            return newInstance(HelpFragment::class.java)
        }
    }
    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHelpBinding {
        return FragmentHelpBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        binding.icBack.setOnClickListener {
            handlerBackPressed()
        }
    }

    override fun handlerBackPressed() {
        super.handlerBackPressed()
        hideFragment(this@HelpFragment)
    }
}