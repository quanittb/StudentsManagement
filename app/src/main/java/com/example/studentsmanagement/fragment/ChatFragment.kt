package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentChatBinding

class ChatFragment:BaseFragment<FragmentChatBinding>() {
    companion object {
        fun instance(): ChatFragment {
            return newInstance(ChatFragment::class.java)
        }
    }
    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentChatBinding {
        return FragmentChatBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        binding.icBack.setOnClickListener {
            hideFragment(this)
        }
    }

    override fun handlerBackPressed() {
        super.handlerBackPressed()
        hideFragment(this)
    }
}