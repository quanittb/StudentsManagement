package com.example.studentsmanagement.activity

import android.content.Context
import android.content.Intent
import android.os.Handler
import com.example.studentsmanagement.base.BaseActivity
import com.example.studentsmanagement.databinding.ActivitySplashBinding
import com.example.studentsmanagement.language.LanguageUtil
import com.example.studentsmanagement.lib.SharedPreferenceUtils


class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    companion object {
        var IS_PUSH = false
        fun startMain(context: Context, clearTask : Boolean ){
            val intent = Intent(context, SplashActivity::class.java).apply {
                if(clearTask){
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            }
            context.startActivity(intent)
        }
    }

    override fun getViewBinding(): ActivitySplashBinding =
        ActivitySplashBinding.inflate(layoutInflater)

    override fun createView() {
        LanguageUtil.setupLanguage(this)
        openNextScreen()
    }



    private fun openNextScreen() {
        Handler().postDelayed({
            if(SharedPreferenceUtils.firstOpenApp)
                LanguageActivity.start(this,false,true)
            else if (!SharedPreferenceUtils.isSignIn)
                SignInActivity.start(this,true)
            else
                MainActivity.startMain(this, true)

        }, 2000)
    }
}