package com.example.studentsmanagement.activity

import android.content.Context
import android.content.Intent
import com.example.studentsmanagement.base.BaseActivity
import com.example.studentsmanagement.databinding.ActivitySigninBinding
import com.example.studentsmanagement.fragment.SignIn1Fragment
import com.example.studentsmanagement.lib.SharedPreferenceUtils

class SignInActivity: BaseActivity<ActivitySigninBinding>() {
    companion object{
        fun start(context: Context, clearTask : Boolean ){
            val intent = Intent(context, SignInActivity::class.java).apply {
                if(clearTask){
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            }
            SharedPreferenceUtils.isSignIn = false
            context.startActivity(intent)
        }

    }
    override fun getViewBinding() = ActivitySigninBinding.inflate(layoutInflater)

    override fun createView() {
        binding.btnPH.setOnClickListener {
            addFragment(SignIn1Fragment.instance())
        }
    }
}