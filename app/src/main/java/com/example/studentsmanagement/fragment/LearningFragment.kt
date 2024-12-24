package com.example.studentsmanagement.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentLearningBinding

class LearningFragment:BaseFragment<FragmentLearningBinding>() {
    companion object{
        fun instance(): LearningFragment{
            return newInstance(LearningFragment::class.java)
        }
    }
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLearningBinding {
        return FragmentLearningBinding.inflate(inflater,container,false)
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