package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.R
import com.example.studentsmanagement.activity.LanguageActivity
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentSettingsBinding

class SettingFragment:BaseFragment<FragmentSettingsBinding>() {
    companion object{
        fun instance():SettingFragment{
            return newInstance(SettingFragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingsBinding {
        return FragmentSettingsBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        binding.icBack.setOnClickListener {
            handlerBackPressed()
        }
        var isNoti = true
        var isDarkMode = false
        binding.lnNot.setOnClickListener {
            isNoti = !isNoti
            if(isNoti)
                binding.tvNoti.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_turn_on, 0)
            else
                binding.tvNoti.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_turn_off, 0)
        }
        binding.lnDarkMode.setOnClickListener {
            isDarkMode = !isDarkMode
            if(isDarkMode)
                binding.tvDarkMode.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_turn_on, 0)
            else
                binding.tvDarkMode.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_turn_off, 0)
        }
        binding.lnLang.setOnClickListener {
            LanguageActivity.start(requireContext(),true,true)
        }

    }

    override fun handlerBackPressed() {
        super.handlerBackPressed()
        hideFragment(this@SettingFragment)
    }
}