package com.example.studentsmanagement.fragment

import android.content.Context
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.example.studentsmanagement.activity.MainActivity
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentSignin2Binding
import com.example.studentsmanagement.lib.SharedPreferenceUtils
import com.example.studentsmanagement.utility.makeGone
import com.example.studentsmanagement.utility.makeVisible

class SignIn2Fragment:BaseFragment<FragmentSignin2Binding>() {
    companion object{
        fun instance():SignIn2Fragment{
            return newInstance(SignIn2Fragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignin2Binding {
        return FragmentSignin2Binding.inflate(inflater,container,false)
    }

    override fun initView() {
        setOTP()
        binding.llOtp.setOnClickListener {
            binding.etOtp.requestFocus()
            val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(binding.etOtp, InputMethodManager.SHOW_IMPLICIT)
        }
        binding.btnConfirm.setOnClickListener {
            performGo()
        }
    }
    private fun setOTP(){
        binding.etOtp.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                when(s!!.length){
                    0 -> {
                        binding.tvOtp1.text = null
                        binding.tvOtp2.text = null
                        binding.tvOtp3.text = null
                        binding.tvOtp4.text = null
                        binding.tvOtp5.text = null
                        binding.tvOtp6.text = null
                        binding.btnConfirm.isEnabled = false
                    }
                    1->{
                        binding.tvOtp1.text = binding.etOtp.text.last().toString()
                        binding.tvOtp2.text = null
                        binding.tvOtp3.text = null
                        binding.tvOtp4.text = null
                        binding.tvOtp5.text = null
                        binding.tvOtp6.text = null
                        binding.btnConfirm.isEnabled = false
                    }
                    2->{
                        binding.tvOtp2.text = binding.etOtp.text.last().toString()
                        binding.tvOtp3.text = null
                        binding.tvOtp4.text = null
                        binding.tvOtp5.text = null
                        binding.tvOtp6.text = null
                        binding.btnConfirm.isEnabled = false
                    }
                    3->{
                        binding.tvOtp3.text = binding.etOtp.text.last().toString()
                        binding.tvOtp4.text = null
                        binding.tvOtp5.text = null
                        binding.tvOtp6.text = null
                        binding.btnConfirm.isEnabled = false
                    }
                    4->{
                        binding.tvOtp4.text = binding.etOtp.text.last().toString()
                        binding.tvOtp5.text = null
                        binding.tvOtp6.text = null
                        binding.btnConfirm.isEnabled = false
                    }
                    5->{
                        binding.tvOtp5.text = binding.etOtp.text.last().toString()
                        binding.tvOtp6.text = null
                        binding.btnConfirm.isEnabled = false
                    }
                    6->{
                        binding.tvOtp6.text = binding.etOtp.text.last().toString()
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if(s!!.length == 6){
                    binding.btnConfirm.isEnabled = true
                    hideKeyboard()
                }
            }
        })
        binding.etOtp.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_GO || event?.action == KeyEvent.ACTION_DOWN) {
                hideKeyboard()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }
    private fun performGo() {
        if(binding.etOtp.text.length == 6){
            binding.layoutLoading.makeVisible()
            Handler().postDelayed({
                MainActivity.startMain(requireContext(),true)
                SharedPreferenceUtils.isSignIn = true
                binding.layoutLoading.makeGone()
            },1000)
        }
    }
    override fun handlerBackPressed() {
        super.handlerBackPressed()
        closeFragment(this@SignIn2Fragment)
    }
}