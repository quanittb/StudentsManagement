package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentNotificationBinding
import com.example.studentsmanagement.databinding.FragmetTkbBinding

class TKBFragment:BaseFragment<FragmetTkbBinding>() {
    companion object{
        fun instance(): TKBFragment{
            return newInstance(TKBFragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmetTkbBinding {
        return FragmetTkbBinding.inflate(inflater,container,false)
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