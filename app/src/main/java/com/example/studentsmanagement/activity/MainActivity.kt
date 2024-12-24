package com.example.studentsmanagement.activity

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.studentsmanagement.R
import com.example.studentsmanagement.adapter.OnClickListener
import com.example.studentsmanagement.databinding.ActivityMainBinding
import com.example.studentsmanagement.base.BaseActivity
import com.example.studentsmanagement.dialog.ProfileDialog
import com.example.studentsmanagement.fragment.AccountFragment
import com.example.studentsmanagement.fragment.ChatFragment
import com.example.studentsmanagement.fragment.DetailProfileFragment
import com.example.studentsmanagement.fragment.HomeFragment
import com.example.studentsmanagement.fragment.HomeworkFragment
import com.example.studentsmanagement.fragment.LearningFragment
import com.example.studentsmanagement.fragment.NotificationFragment
import com.example.studentsmanagement.utility.makeInvisible
import com.example.studentsmanagement.utility.makeVisible
import com.example.studentsmanagement.utility.rxbus.NotiBack
import com.example.studentsmanagement.utility.rxbus.listenEvent

class MainActivity : BaseActivity<ActivityMainBinding>(){
    companion object{
        fun startMain(context: Context, clearTask : Boolean ){
            val intent = Intent(context, MainActivity::class.java).apply {
                if(clearTask){
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            }
            context.startActivity(intent)
        }

    }
    private val HOME_FRAGMENT = HomeFragment.instance()
    private val NOTIFICATION_FRAGMENT = NotificationFragment.instance()
    private val LEARNING_FRAGMENT = LearningFragment.instance()
    private val HOMEWORK_FRAGMENT = HomeworkFragment.instance()
    private val ACCOUNT_FRAGMENT = AccountFragment.instance()
    private var currentFragment  : Fragment = HOME_FRAGMENT
    private var isSelectNoti= false


    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun createView() {
        supportFragmentManager.beginTransaction()
            .add(binding.layoutAddFragmentMain.id,HOME_FRAGMENT)
            .add(binding.layoutAddFragmentMain.id,NOTIFICATION_FRAGMENT)
            .add(binding.layoutAddFragmentMain.id,LEARNING_FRAGMENT)
            .add(binding.layoutAddFragmentMain.id,HOMEWORK_FRAGMENT)
            .add(binding.layoutAddFragmentMain.id,ACCOUNT_FRAGMENT)
            .hide(NOTIFICATION_FRAGMENT)
            .hide(LEARNING_FRAGMENT)
            .hide(HOMEWORK_FRAGMENT)
            .hide(ACCOUNT_FRAGMENT)
            .show(HOME_FRAGMENT).commit()
        setListener()
        handlerEvent()
    }
    private fun showFragment(showFragment: Fragment, hideFragment: Fragment){
            supportFragmentManager.beginTransaction()
                .show(showFragment).hide(hideFragment).commitAllowingStateLoss()
    }
    fun setListener(){
        binding.icChat.setOnClickListener {
            addFragment(ChatFragment.instance())
        }
        binding.icNoti.setOnClickListener {
            if(currentFragment== NOTIFICATION_FRAGMENT)
                return@setOnClickListener
            if(!isSelectNoti)
                binding.icNoti.setImageDrawable(getDrawable(R.drawable.ic_noti_select))
            else
                binding.icNoti.setImageDrawable(getDrawable(R.drawable.ic_noti))

            isSelectNoti = !isSelectNoti
            showFragment(NOTIFICATION_FRAGMENT,currentFragment)
            currentFragment = NOTIFICATION_FRAGMENT

        }
        binding.btnProfile.setOnClickListener{
            val profileDialog = ProfileDialog(this, object : OnClickListener{
                override fun onClickDetail() {
                    addFragment(DetailProfileFragment.instance())
                }
            })
            profileDialog.show()
        }
        binding.bottomNav.selectedItemId = R.id.action_home
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    binding.icNoti.setImageDrawable(getDrawable(R.drawable.ic_noti))
                    isSelectNoti = false
                    if (currentFragment != HOME_FRAGMENT){
                        setIndex(1)
                        showFragment(HOME_FRAGMENT,currentFragment)
                        currentFragment = HOME_FRAGMENT

                    }
                }
                R.id.action_learning -> {
                    binding.icNoti.setImageDrawable(getDrawable(R.drawable.ic_noti))
                    isSelectNoti = false
                    setIndex(2)
                    if (currentFragment != LEARNING_FRAGMENT){
                        showFragment(LEARNING_FRAGMENT,currentFragment)
                        currentFragment = LEARNING_FRAGMENT
                    }

                }
                R.id.action_homework -> {
                    binding.icNoti.setImageDrawable(getDrawable(R.drawable.ic_noti))
                    isSelectNoti = false
                    setIndex(3)
                    if (currentFragment != HOMEWORK_FRAGMENT){
                        showFragment(HOMEWORK_FRAGMENT,currentFragment)
                        currentFragment = HOMEWORK_FRAGMENT
                    }
                }
                R.id.action_account -> {
                    binding.icNoti.setImageDrawable(getDrawable(R.drawable.ic_noti))
                    isSelectNoti = false
                    setIndex(4)
                    if (currentFragment != ACCOUNT_FRAGMENT){
                        showFragment(ACCOUNT_FRAGMENT,currentFragment)
                        currentFragment = ACCOUNT_FRAGMENT
                    }
                }
            }
            true
        }
    }

    private fun setIndex(index: Int){
        binding.run {
            when(index){
                1-> {
                    line1.makeVisible()
                    line2.makeInvisible()
                    line3.makeInvisible()
                    line4.makeInvisible()
                }
                2-> {
                    line2.makeVisible()
                    line1.makeInvisible()
                    line3.makeInvisible()
                    line4.makeInvisible()
                }
                3-> {
                    line3.makeVisible()
                    line2.makeInvisible()
                    line1.makeInvisible()
                    line4.makeInvisible()
                }
                4-> {
                    line4.makeVisible()
                    line2.makeInvisible()
                    line3.makeInvisible()
                    line1.makeInvisible()
                }
            }
        }

    }
    private fun handlerEvent() {
        this.addDispose(listenEvent({
            when (it) {
                is NotiBack -> {
                    currentFragment = HOME_FRAGMENT
                    isSelectNoti = false
                    binding.icNoti.setImageDrawable(getDrawable(R.drawable.ic_noti))
                }
            }
        }, {}))
    }

}