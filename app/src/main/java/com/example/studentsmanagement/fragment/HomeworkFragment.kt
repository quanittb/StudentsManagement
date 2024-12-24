package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentHomeworkBinding

class HomeworkFragment:BaseFragment<FragmentHomeworkBinding>() {
    companion object{
        fun instance():HomeworkFragment{
            return newInstance(HomeworkFragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeworkBinding {
        return FragmentHomeworkBinding.inflate(inflater,container,false)
    }

    override fun initView() {
    }
    override fun handlerBackPressed() {
        super.handlerBackPressed()
        requireActivity().run {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStackImmediate();
            }

            if (supportFragmentManager.backStackEntryCount == 0) {
                finish()
            }
        }
    }
}