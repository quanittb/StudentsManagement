package com.example.studentsmanagement.fragment

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentSignin1Binding
import com.example.studentsmanagement.utility.makeInvisible
import com.example.studentsmanagement.utility.makeVisible

class SignIn1Fragment:BaseFragment<FragmentSignin1Binding>() {
    companion object{
        fun instance():SignIn1Fragment{
            return newInstance(SignIn1Fragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignin1Binding {
        return FragmentSignin1Binding.inflate(inflater,container,false)
    }

    override fun initView() {
        binding.btnOtp.setOnClickListener {
            hideKeyboard()
            if(binding.tvSdt.text.toString() == "0123456789")
                addFragment(SignIn2Fragment.instance())
            else
                binding.tvWarning.makeVisible()
        }
        binding.tvSdt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tvWarning.makeInvisible()
                binding.btnOtp.isEnabled = s!!.length==10
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    override fun handlerBackPressed() {
        super.handlerBackPressed()
        hideFragment(this@SignIn1Fragment)
    }
}