package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentDetailProfileBinding

class DetailProfileFragment:BaseFragment<FragmentDetailProfileBinding>() {
    companion object{
        fun instance():DetailProfileFragment{
            return newInstance(DetailProfileFragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailProfileBinding {
        return FragmentDetailProfileBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        binding.icBack.setOnClickListener {
            handlerBackPressed()
        }

    }

    override fun handlerBackPressed() {
        super.handlerBackPressed()
        hideFragment(this@DetailProfileFragment)
    }
}