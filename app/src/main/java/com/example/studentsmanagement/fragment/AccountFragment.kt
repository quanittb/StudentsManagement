package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.activity.SignInActivity
import com.example.studentsmanagement.adapter.OnClickListener
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentAccountBinding
import com.example.studentsmanagement.dialog.SignOutDialog

class AccountFragment:BaseFragment<FragmentAccountBinding>() {
    companion object{
        fun instance():AccountFragment{
            return newInstance(AccountFragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAccountBinding {
        return FragmentAccountBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        binding.btnSignout.setOnClickListener{
            val dialog = SignOutDialog(requireContext(),object :OnClickListener{
                override fun onClickDetail() {
                    SignInActivity.start(requireContext(),true)
                }
            })
            dialog.show()
        }
        binding.btnProfile.setOnClickListener {
            addFragment(DetailProfileFragment.instance())
        }
        binding.btnHelp.setOnClickListener {
            addFragment(HelpFragment.instance())
        }
        binding.btnSetting.setOnClickListener {
            addFragment(SettingFragment.instance())
        }
    }
}