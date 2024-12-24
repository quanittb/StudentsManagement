package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.quanpham.utility.rxbus.RxBus
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentNotificationBinding
import com.example.studentsmanagement.utility.rxbus.NotiBack

class NotificationFragment:BaseFragment<FragmentNotificationBinding>() {
    companion object{
        fun instance(): NotificationFragment{
            return newInstance(NotificationFragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater,container,false)
    }

    override fun initView() {

    }

    override fun handlerBackPressed() {
        super.handlerBackPressed()
        RxBus.publish(NotiBack())
        hideFragment(this)

    }
}