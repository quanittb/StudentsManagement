package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.R
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentHocthemBinding
import com.example.studentsmanagement.databinding.FragmentLichthiBinding
import com.example.studentsmanagement.databinding.FragmentNotificationBinding
import com.example.studentsmanagement.databinding.FragmetTkbBinding

class HocThemFragment:BaseFragment<FragmentHocthemBinding>() {
    companion object{
        fun instance(): HocThemFragment{
            return newInstance(HocThemFragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHocthemBinding {
        return FragmentHocthemBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        binding.icBack.setOnClickListener {
            handlerBackPressed()
        }
        var isToan = true
        var isLy = false
        var isHoa = false
        var isVan = true
        var isAnh = true
        binding.tvToan.setOnClickListener {
            isToan = !isToan
            if(isToan)
                binding.tvToan.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_select_mon, 0)
            else
                binding.tvToan.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselect_mon, 0)
        }
        binding.tvLy.setOnClickListener {
            isLy = !isLy
            if(isLy)
                binding.tvLy.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_select_mon, 0)
            else
                binding.tvLy.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselect_mon, 0)
        }
        binding.tvHoa.setOnClickListener {
            isHoa = !isHoa
            if(isHoa)
                binding.tvHoa.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_select_mon, 0)
            else
                binding.tvHoa.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselect_mon, 0)
        }
        binding.tvVan.setOnClickListener {
            isVan = !isVan
            if(isVan)
                binding.tvVan.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_select_mon, 0)
            else
                binding.tvVan.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselect_mon, 0)
        }
        binding.tvTienganh.setOnClickListener {
            isAnh = !isAnh
            if(isAnh)
                binding.tvTienganh.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_select_mon, 0)
            else
                binding.tvTienganh.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unselect_mon, 0)
        }
    }

    override fun handlerBackPressed() {
        super.handlerBackPressed()
        hideFragment(this)
    }
}