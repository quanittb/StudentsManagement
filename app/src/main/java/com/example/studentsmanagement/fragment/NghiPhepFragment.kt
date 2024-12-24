package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.activity.MainActivity
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentNghiphepBinding
import com.example.studentsmanagement.dialog.CancelDropDownMenu

class NghiPhepFragment:BaseFragment<FragmentNghiphepBinding>() {
    companion object{
        fun instance():NghiPhepFragment{
            return newInstance(NghiPhepFragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNghiphepBinding {
        return FragmentNghiphepBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        binding.icBack.setOnClickListener {
            handlerBackPressed()
        }
        binding.txtLydo.setOnClickListener {
            CancelDropDownMenu.showDropDown(
                requireActivity() as MainActivity, binding.txtLydo,
            ) {
                handleDropDownMenuClick(it)
            }
        }
    }
    private fun handleDropDownMenuClick(text: String) {
        binding.txtLydo.text = text
    }

    override fun handlerBackPressed() {
        super.handlerBackPressed()
        hideFragment(this@NghiPhepFragment)
    }
}